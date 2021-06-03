package org.mongo.zee.Dao;

import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.mongo.zee.model.Student;
import org.springframework.data.domain.Page;

import java.io.IOException;
import java.util.List;

public interface StudentDao {

    Page<Student> getByPage(int page);

    void saveStudent(Student student);

    void saveStudent(Student student, String city);

    void deleteStudent(Student student, String id);

    void deleteAllStudents();

    List<Student> filterStudentless(Integer number) ;

    List<Student> filterStudentltgt( Integer lt,  Integer gt);

    List<Student> filterStudentin();

    List<Student> filterStudentne();

    List<Student> findbyname(String name, Integer pageno);

    List<Student> findbycity(String city, Integer pageno);

    List<Student> salgreat( Integer great,  Integer pageno);

    List<Student> salless( Integer less,  Integer pageno);

    List<Student> salbetw( Integer less,  Integer great,  Integer pageno);

    Document grouping();

    Document counting();

    Document Avg();

    UpdateResult incSalary( String city,  Long increment);

    JSONObject jsonFile() throws IOException, ParseException;

    JSONArray jsonFileo() throws IOException, ParseException;
}
