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
		return new ResponseEntity<>(studentDao.getByPage(pageno), HttpStatus.OK);
	}

	@PostMapping("/")
	public void addStudents(@RequestBody Student student) {
		studentDao.saveStudent(student);
	}

	@PutMapping("/{city}")
	public void addStudents(@RequestBody Student student, @PathVariable String city) {
		studentDao.saveStudent(student, city);
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
		return new ResponseEntity<>(studentDao.filterStudentless(number), HttpStatus.OK);
	}


	@GetMapping("/filterltgt/{lt}/{gt}")
	public ResponseEntity<List<Student>> filterStudentltgt(@PathVariable Integer lt, @PathVariable Integer gt) {
		return new ResponseEntity<>(studentDao.filterStudentltgt(lt, gt), HttpStatus.OK);
	}


	@GetMapping("/filterin")
	public ResponseEntity<List<Student>> filterStudentin() {
		return new ResponseEntity<>(studentDao.filterStudentin(), HttpStatus.OK);
	}

	@GetMapping("/filterne")
	public ResponseEntity<List<Student>> filterStudentne() {
		return new ResponseEntity<>(studentDao.filterStudentne(), HttpStatus.OK);
	}

	@GetMapping("/name/{name}/{pageno}")
	public ResponseEntity<List<Student>>findbyname(@PathVariable String name, @PathVariable Integer pageno) {
		return new ResponseEntity<>(studentDao.findbyname(name, pageno), HttpStatus.OK);
	}

	@GetMapping("/city/{city}/{pageno}")
	public ResponseEntity<List<Student>> findbycity(@PathVariable String city, @PathVariable Integer pageno) {
		return new ResponseEntity<>(studentDao.findbycity(city, pageno), HttpStatus.OK);
	}

	@GetMapping("/salgreat/{great}/{pageno}")
	public ResponseEntity<List<Student>> salgreat(@PathVariable Integer great, @PathVariable Integer pageno) {
		return new ResponseEntity<>(studentDao.salgreat(great, pageno), HttpStatus.OK);
	}

	@GetMapping("/salless/{less}/{pageno}")
	public ResponseEntity<List<Student>> salless(@PathVariable Integer less, @PathVariable Integer pageno) {
		return new ResponseEntity<>(studentDao.salless(less, pageno), HttpStatus.OK);
	}

	@GetMapping("/salbetw/{less}/{great}/{pageno}")
	public ResponseEntity<List<Student>> salbetw(@PathVariable Integer less, @PathVariable Integer great, @PathVariable Integer pageno) {
		return  new ResponseEntity<>(studentDao.salbetw(less, great, pageno), HttpStatus.OK);
	}

	@GetMapping("/groupBySalaryAndSum")
	public ResponseEntity<Document> grouping() {
		return new ResponseEntity<>(studentDao.grouping(), HttpStatus.OK);
	}


	@GetMapping("/groupBySalaryAndCount")
	public ResponseEntity<Document> counting() {
		return new ResponseEntity<>(studentDao.counting(), HttpStatus.OK);
	}

	@GetMapping("/groupByCityAndAvgSalary")
	public ResponseEntity<Document> Avg() {
		return new ResponseEntity<>(studentDao.Avg(), HttpStatus.OK);
	}


	@GetMapping("/inc/{city}/{increment}")
	public ResponseEntity<UpdateResult> incSalary(@PathVariable String city, @PathVariable Long increment) {
		return new ResponseEntity<>(studentDao.incSalary(city, increment), HttpStatus.OK);
	}


	@GetMapping("/json")
	public ResponseEntity<JSONObject> jsonFile() throws IOException, ParseException {
		return new ResponseEntity<>(studentDao.jsonFile(), HttpStatus.OK);
	}


	@GetMapping("/json2")
	public ResponseEntity<JSONArray> jsonFileo() throws IOException, ParseException {
		return new ResponseEntity<>(studentDao.jsonFileo(), HttpStatus.OK);
	}

}