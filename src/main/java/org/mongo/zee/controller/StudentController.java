package org.mongo.zee.controller;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


@RestController
public class StudentController {

	private StudentRepository studentRepository;


	@Autowired
	private MongoTemplate mongoTemplate;

	public StudentController(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	@GetMapping("/{pageno}")
	public Page<Student> getStudents(@PathVariable Integer pageno) {
		List<Student> li = studentRepository.findAll();
		for (Student stu : li) {
			System.out.print(stu.getName());
		}
		Pageable paging = PageRequest.of(pageno, 3, Sort.Direction.ASC, "salary");
		return studentRepository.findAll(paging);
	}

	@PostMapping("/")
	public void addStudents(@RequestBody Student student) {
		studentRepository.save(student);

	}

	@PutMapping("/{city}")
	public void addStudents(@RequestBody Student student, @PathVariable String city) {
		student.setCity(city);
		studentRepository.save(student);

	}

	@DeleteMapping("/{id}")
	public void deleteStudents(@RequestBody Student student, @PathVariable String id) {
		studentRepository.deleteById(id);

	}

	@DeleteMapping("/")
	public void deleteAll() {
		studentRepository.deleteAll();

	}


	@GetMapping("/filterlt/{number}")
	public List<Student> filterStudentlt(@PathVariable Integer number) {
		return mongoTemplate.find(query(where("salary").lt(number)), Student.class);
		// .and("id").gt(3))
//		AggregationOperation
//		Aggregation aggregation2
//				= Aggregation.group().sum().
//		GroupOperation groupByStateAndSumPop = group("state")
//				.sum("pop").as("statePop");
//		mongoTemplate.
	}


	@GetMapping("/filterltgt/{lt}/{gt}")
	public List<Student> filterStudentltgt(@PathVariable Integer lt, @PathVariable Integer gt) {
		return mongoTemplate.find(query(where("salary").lt(lt).gte(gt)), Student.class);
		//
	}


	@GetMapping("/filterin")
	public List<Student> filterStudentin() {
		return mongoTemplate.find(query(where("salary").in(500000, 20000, 10000).and("id").is("4")), Student.class);
		//
	}
//
//	@GetMapping("/filterinWithFilters")
//	public List <Student> filterStudent() {
//		return mongoTemplate.find(query(Criteria.where("salary").lt()));
//		//
//	}


	@GetMapping("/filterne")
	public List<Student> filterStudentne() {
		return mongoTemplate.find(query(where("salary").ne(10000).and("id").ne("7")), Student.class);

		//
	}


	@GetMapping("/page/{pageno}")
	public Page<Student> paging(@PathVariable Integer pageno) {
		Pageable paging = PageRequest.of(pageno, 3, Sort.Direction.ASC, "salary");
		Page<Student> students = studentRepository.findAll(paging);
		return students;
	}


	@GetMapping("/name/{name}/{pageno}")
	public List<Student> findbyname(@PathVariable String name, @PathVariable Integer pageno) {
		Pageable paging = PageRequest.of(pageno, 3, Sort.Direction.ASC, "salary");
		return studentRepository.findByName(name, paging);
		//
	}

	@GetMapping("/city/{city}/{pageno}")
	public List<Student> findbycity(@PathVariable String city, @PathVariable Integer pageno) {
		Pageable paging = PageRequest.of(pageno, 3, Sort.Direction.ASC, "salary");
		return studentRepository.findByCity(city, paging);
		//
	}


	@GetMapping("/salgreat/{great}/{pageno}")
	public List<Student> salgreat(@PathVariable Integer great, @PathVariable Integer pageno) {
		Pageable paging = PageRequest.of(pageno, 3, Sort.Direction.ASC, "salary");
		return studentRepository.findBySalaryGreaterThan(great, paging);
		//
	}


	@GetMapping("/salless/{less}/{pageno}")
	public List<Student> salless(@PathVariable Integer less, @PathVariable Integer pageno) {
		Pageable paging = PageRequest.of(pageno, 3, Sort.Direction.ASC, "salary");
		return studentRepository.findBySalaryLessThan(less, paging);
		//
	}


	@GetMapping("/salbetw/{less}/{great}/{pageno}")
	public List<Student> salbetw(@PathVariable Integer less, @PathVariable Integer great, @PathVariable Integer pageno) {
		Pageable paging = PageRequest.of(pageno, 3, Sort.Direction.ASC, "salary");
		return studentRepository.findBySalaryBetween(great, less, paging);
		//
	}


	@GetMapping("/groupBySalaryAndSum")
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

		//
	}


	@GetMapping("/groupBySalaryAndCount")
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

	@GetMapping("/groupByCityAndAvgSalary")
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


	@GetMapping("/inc/{city}/{increment}")
	public UpdateResult incSalary(@PathVariable String city, @PathVariable Long increment) {
		return mongoTemplate.updateMulti(Query.query(Criteria.where("city").is(city))
				, new Update().inc("salary", increment), Student.class);
		//
	}


	@GetMapping("/json")
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


	@GetMapping("/json2")
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