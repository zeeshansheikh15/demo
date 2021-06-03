package org.mongo.zee.DaoImpl;

import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.mongo.zee.Dao.StudentDao;
import org.mongo.zee.model.Student;
import org.mongo.zee.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Service
public class StudentDaoImpl implements StudentDao {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Page<Student> getByPage(int pageno) {
        Pageable paging = PageRequest.of(pageno, 3, Sort.Direction.ASC, "salary");
        return studentRepository.findAll(paging);
    }

    @Override
    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void saveStudent(Student student, String city) {
        student.setCity(city);
        studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Student student, String id) {
        studentRepository.deleteById(id);
    }

    @Override
    public void deleteAllStudents() {
        studentRepository.deleteAll();
    }

    @Override
    public List<Student> filterStudentless(Integer number) {
        return mongoTemplate.find(query(where("salary").lt(number)), Student.class);
    }

    @Override
    public List<Student> filterStudentltgt(Integer lt, Integer gt) {
        return mongoTemplate.find(query(where("salary").lt(lt).gte(gt)), Student.class);
    }

    @Override
    public List<Student> filterStudentin() {
        ArrayList<Criteria> criterias = new ArrayList<>();
        criterias.add(Criteria.where("salary").in(500000, 20000, 10000));
        criterias.add(Criteria.where("id").is("4"));
        Criteria criteria = new Criteria().andOperator(criterias.toArray(new Criteria[criterias.size()]));
        return mongoTemplate.find(query(criteria), Student.class);
    }

    @Override
    public List<Student> filterStudentne() {
        return mongoTemplate.find(query(where("salary").ne(10000).and("id").ne("7")), Student.class);
    }

    @Override
    public List<Student> findbyname(String name, Integer pageno) {
        Pageable paging = PageRequest.of(pageno, 3, Sort.Direction.ASC, "salary");
        return studentRepository.findByName(name, paging);
    }

    @Override
    public List<Student> findbycity(String city, Integer pageno) {
        Pageable paging = PageRequest.of(pageno, 3, Sort.Direction.ASC, "salary");
        return studentRepository.findByCity(city, paging);
    }

    @Override
    public List<Student> salgreat(Integer great, Integer pageno) {
        Pageable paging = PageRequest.of(pageno, 3, Sort.Direction.ASC, "salary");
        return studentRepository.findBySalaryGreaterThan(great, paging);
    }

    @Override
    public List<Student> salless(Integer less, Integer pageno) {
        Pageable paging = PageRequest.of(pageno, 3, Sort.Direction.ASC, "salary");
        return studentRepository.findBySalaryLessThan(less, paging);
    }

    @Override
    public List<Student> salbetw(Integer less, Integer great, Integer pageno) {
        Pageable paging = PageRequest.of(pageno, 3, Sort.Direction.ASC, "salary");
        return studentRepository.findBySalaryBetween(great, less, paging);
    }

    @Override
    public Document grouping() {
        GroupOperation groupByCity = group("city")
                .sum("salary").as("salary");
        MatchOperation salFilter = match(new Criteria("salary").gt(1000));
        SortOperation sortBySalaryDesc = sort(Sort.by(Sort.Direction.DESC, "salary"));

        Aggregation aggregation = newAggregation(groupByCity, salFilter, sortBySalaryDesc);
        AggregationResults<Student> result = mongoTemplate.aggregate(
                aggregation, "student", Student.class);
        System.out.print(result.getMappedResults());
        return result.getRawResults();
    }

    @Override
    public Document counting() {
        MatchOperation salFilter = match(new Criteria("salary").gt(20000));
        GroupOperation countSalaries = group("city").count().as("num");

        SortOperation sortBySalaryDesc = sort(Sort.by(Sort.Direction.DESC, "num"));

        Aggregation aggregation = newAggregation(salFilter, countSalaries, sortBySalaryDesc);
        AggregationResults<Student> result = mongoTemplate.aggregate(
                aggregation, "student", Student.class);
        System.out.print(result);
        return result.getRawResults();
    }

    @Override
    public Document Avg() {
        MatchOperation salFilter = match(new Criteria("salary").gt(20000));
        GroupOperation countSalaries = group("city").avg("salary").as("avg");
        SortOperation sortBySalaryDesc = sort(Sort.by(Sort.Direction.DESC, "avg"));

        Aggregation aggregation = newAggregation(salFilter, countSalaries, sortBySalaryDesc);
        AggregationResults<Student> result = mongoTemplate.aggregate(
                aggregation, "student", Student.class);

        System.out.print(result);
        return result.getRawResults();
    }

    @Override
    public UpdateResult incSalary(String city, Long increment) {
        return mongoTemplate.updateMulti(Query.query(Criteria.where("city").is(city))
                , new Update().inc("salary", increment), Student.class);
    }

    @Override
    public JSONObject jsonFile() throws IOException, ParseException {
        FileReader fileReader = new FileReader("src/main/resources/data2.json");
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(fileReader);

        for (Object keyStr : jsonObject.keySet()) {
            Object keyvalue = jsonObject.get(keyStr);
            System.out.println("key: " + keyStr + " value: " + keyvalue);
        }
        return jsonObject;
    }

    @Override
    public JSONArray jsonFileo() throws IOException, ParseException {
        FileReader fileReader = new FileReader("src/main/resources/data2.json");
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(fileReader);
        JSONArray jsonArray = new JSONArray();
        for (Object keyStr : jsonObject.keySet()) {
            JSONObject inner = (JSONObject) jsonObject.get(keyStr);
            for (Object innervalue : inner.keySet()){
                if(innervalue.equals("title")) {
                    JSONObject jsonObject1 = new JSONObject();
                    jsonObject1.put(innervalue, inner.get(innervalue));
                    jsonArray.add(jsonObject1);
                    System.out.println("key: " + innervalue + " value: " + inner.get(innervalue));
                }
            }

        }
        return jsonArray;
    }


}
