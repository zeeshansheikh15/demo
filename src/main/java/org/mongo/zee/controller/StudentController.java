package org.mongo.zee.controller;

import java.io.IOException;
import java.util.List;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.mongo.zee.DaoImpl.StudentDaoImpl;
import org.mongo.zee.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.json.simple.parser.ParseException;


@RestController
public class StudentController {

	@Autowired
	private StudentDaoImpl studentDao;

	@GetMapping("/{pageno}")
	public ResponseEntity<Page<Student>> getStudents(@PathVariable Integer pageno) {
		if(studentDao.getByPage(pageno)!=null)
			return new ResponseEntity<>(studentDao.getByPage(pageno), HttpStatus.OK);
		else
			return new ResponseEntity<>(studentDao.getByPage(pageno), HttpStatus.NO_CONTENT);
	}

	@PostMapping("/")
	public ResponseEntity<Student> addStudents(@RequestBody Student student) {
		if(studentDao.saveStudent(student)!=null)
			return new ResponseEntity<>(studentDao.saveStudent(student), HttpStatus.OK);
		else
			return new ResponseEntity<>(studentDao.saveStudent(student) , HttpStatus.NO_CONTENT);
	}

	@PutMapping("/{city}")
	public ResponseEntity<Student> addStudents(@RequestBody Student student, @PathVariable String city) {
		if(studentDao.saveStudent(student, city)!=null)
			return new ResponseEntity<>(studentDao.saveStudent(student, city), HttpStatus.OK);
		else
			return new ResponseEntity<>(studentDao.saveStudent(student, city) , HttpStatus.NO_CONTENT);
	}

	@DeleteMapping("/{id}")
	public void deleteStudents(@RequestBody Student student, @PathVariable String id) {
		studentDao.deleteStudent(student, id);
	}

	@DeleteMapping("/")
	public void deleteAll() {
		studentDao.deleteAllStudents();
	}


	@GetMapping("/filterlt/{number}")
	public ResponseEntity<List<Student>> filterStudentlt(@PathVariable Integer number) {
		if(studentDao.filterStudentless(number)!=null)
			return new ResponseEntity<>(studentDao.filterStudentless(number), HttpStatus.OK);
		else
			return new ResponseEntity<>(studentDao.filterStudentless(number) , HttpStatus.NO_CONTENT);

	}


	@GetMapping("/filterltgt/{lt}/{gt}")
	public ResponseEntity<List<Student>> filterStudentltgt(@PathVariable Integer lt, @PathVariable Integer gt) {
		if(studentDao.filterStudentltgt(lt, gt)!=null)
			return new ResponseEntity<>(studentDao.filterStudentltgt(lt, gt), HttpStatus.OK);
		else
			return new ResponseEntity<>(studentDao.filterStudentltgt(lt, gt) , HttpStatus.NO_CONTENT);
	}


	@GetMapping("/filterin")
	public ResponseEntity<List<Student>> filterStudentin() {
		if(studentDao.filterStudentin()!=null)
			return new ResponseEntity<>(studentDao.filterStudentin(), HttpStatus.OK);
		else
			return new ResponseEntity<>(studentDao.filterStudentin() , HttpStatus.NO_CONTENT);
	}

	@GetMapping("/filterne")
	public ResponseEntity<List<Student>> filterStudentne() {
		if(studentDao.filterStudentne()!=null)
			return new ResponseEntity<>(studentDao.filterStudentne(), HttpStatus.OK);
		else
			return new ResponseEntity<>(studentDao.filterStudentne() , HttpStatus.NO_CONTENT);
	}

	@GetMapping("/name/{name}/{pageno}")
	public ResponseEntity<List<Student>>findbyname(@PathVariable String name, @PathVariable Integer pageno) {
		if(studentDao.findbyname(name, pageno)!=null)
			return new ResponseEntity<>(studentDao.findbyname(name, pageno), HttpStatus.OK);
		else
			return new ResponseEntity<>(studentDao.findbyname(name, pageno) , HttpStatus.NO_CONTENT);
	}

	@GetMapping("/city/{city}/{pageno}")
	public ResponseEntity<List<Student>> findbycity(@PathVariable String city, @PathVariable Integer pageno) {
		if(studentDao.findbycity(city, pageno)!=null)
			return new ResponseEntity<>(studentDao.findbycity(city, pageno), HttpStatus.OK);
		else
			return new ResponseEntity<>(studentDao.findbycity(city, pageno) , HttpStatus.NO_CONTENT);
	}

	@GetMapping("/salgreat/{great}/{pageno}")
	public ResponseEntity<List<Student>> salgreat(@PathVariable Integer great, @PathVariable Integer pageno) {
		if(studentDao.salgreat(great, pageno)!=null)
			return new ResponseEntity<>(studentDao.salgreat(great, pageno), HttpStatus.OK);
		else
			return new ResponseEntity<>(studentDao.salgreat(great, pageno) , HttpStatus.NO_CONTENT);
	}

	@GetMapping("/salless/{less}/{pageno}")
	public ResponseEntity<List<Student>> salless(@PathVariable Integer less, @PathVariable Integer pageno) {
		if(studentDao.salless(less, pageno)!=null)
			return new ResponseEntity<>(studentDao.salless(less, pageno), HttpStatus.OK);
		else
			return new ResponseEntity<>(studentDao.salless(less, pageno) , HttpStatus.NO_CONTENT);
	}

	@GetMapping("/salbetw/{less}/{great}/{pageno}")
	public ResponseEntity<List<Student>> salbetw(@PathVariable Integer less, @PathVariable Integer great, @PathVariable Integer pageno) {
		if(studentDao.salbetw(less, great, pageno)!=null)
			return new ResponseEntity<>(studentDao.salbetw(less, great, pageno), HttpStatus.OK);
		else
			return new ResponseEntity<>(studentDao.salbetw(less, great, pageno), HttpStatus.NO_CONTENT);
	}

	@GetMapping("/groupBySalaryAndSum")
	public ResponseEntity<Document> grouping() {
		if(studentDao.grouping()!=null)
			return new ResponseEntity<>(studentDao.grouping(), HttpStatus.OK);
		else
			return new ResponseEntity<>(studentDao.grouping(), HttpStatus.NO_CONTENT);
	}


	@GetMapping("/groupBySalaryAndCount")
	public ResponseEntity<Document> counting() {
		if(studentDao.counting()!=null)
			return new ResponseEntity<>(studentDao.counting(), HttpStatus.OK);
		else
			return new ResponseEntity<>(studentDao.counting(), HttpStatus.NO_CONTENT);
	}

	@GetMapping("/groupByCityAndAvgSalary")
	public ResponseEntity<Document> Avg() {
		if(studentDao.Avg()!=null)
			return new ResponseEntity<>(studentDao.Avg(), HttpStatus.OK);
		else
			return new ResponseEntity<>(studentDao.Avg(), HttpStatus.NO_CONTENT);
	}


	@GetMapping("/inc/{city}/{increment}")
	public ResponseEntity<UpdateResult> incSalary(@PathVariable String city, @PathVariable Long increment) {
		if(studentDao.incSalary(city, increment)!=null)
			return new ResponseEntity<>(studentDao.incSalary(city, increment), HttpStatus.OK);
		else
			return new ResponseEntity<>(studentDao.incSalary(city, increment), HttpStatus.NO_CONTENT);
	}


	@GetMapping("/json")
	public ResponseEntity<JSONObject> jsonFile() throws IOException, ParseException {
		if(studentDao.jsonFile()!=null)
			return new ResponseEntity<>(studentDao.jsonFile(), HttpStatus.OK);
		else
			return new ResponseEntity<>(studentDao.jsonFile(), HttpStatus.NO_CONTENT);
	}


	@GetMapping("/json2")
	public ResponseEntity<JSONArray> jsonFileo() throws IOException, ParseException {
		if(studentDao.jsonFileo()!=null)
			return new ResponseEntity<>(studentDao.jsonFileo(), HttpStatus.OK);
		else
			return new ResponseEntity<>(studentDao.jsonFileo(), HttpStatus.NO_CONTENT);
	}

}