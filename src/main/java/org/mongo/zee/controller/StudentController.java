package org.mongo.zee.controller;

import java.io.IOException;
import java.util.List;


import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.mongo.zee.StudentDao.StudentDaoImpl;
import org.mongo.zee.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
	public Page<Student> getStudents(@PathVariable Integer pageno) {
		return studentDao.getByPage(pageno);
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
	public List<Student> filterStudentlt(@PathVariable Integer number) {
		return studentDao.filterStudentless(number);
	}


	@GetMapping("/filterltgt/{lt}/{gt}")
	public List<Student> filterStudentltgt(@PathVariable Integer lt, @PathVariable Integer gt) {
		return studentDao.filterStudentltgt(lt, gt);
	}


	@GetMapping("/filterin")
	public List<Student> filterStudentin() {
		return studentDao.filterStudentin();
	}

	@GetMapping("/filterne")
	public List<Student> filterStudentne() {
		return studentDao.filterStudentne();
	}

	@GetMapping("/name/{name}/{pageno}")
	public List<Student> findbyname(@PathVariable String name, @PathVariable Integer pageno) {
		return studentDao.findbyname(name, pageno);
	}

	@GetMapping("/city/{city}/{pageno}")
	public List<Student> findbycity(@PathVariable String city, @PathVariable Integer pageno) {
		return studentDao.findbycity(city, pageno);
	}

	@GetMapping("/salgreat/{great}/{pageno}")
	public List<Student> salgreat(@PathVariable Integer great, @PathVariable Integer pageno) {
		return studentDao.salgreat(great, pageno);
	}

	@GetMapping("/salless/{less}/{pageno}")
	public List<Student> salless(@PathVariable Integer less, @PathVariable Integer pageno) {
		return studentDao.salless(less, pageno);
	}

	@GetMapping("/salbetw/{less}/{great}/{pageno}")
	public List<Student> salbetw(@PathVariable Integer less, @PathVariable Integer great, @PathVariable Integer pageno) {
		return  studentDao.salbetw(less, great, pageno);
	}

	@GetMapping("/groupBySalaryAndSum")
	public Document grouping() {
		return studentDao.grouping();
	}


	@GetMapping("/groupBySalaryAndCount")
	public Document counting() {
		return studentDao.counting();
	}

	@GetMapping("/groupByCityAndAvgSalary")
	public Document Avg() {
		return studentDao.Avg();
	}


	@GetMapping("/inc/{city}/{increment}")
	public UpdateResult incSalary(@PathVariable String city, @PathVariable Long increment) {
		return studentDao.incSalary(city, increment);
	}


	@GetMapping("/json")
	public JSONObject jsonFile() throws IOException, ParseException {
		return studentDao.jsonFile();
	}


	@GetMapping("/json2")
	public JSONArray jsonFileo() throws IOException, ParseException {
		return studentDao.jsonFileo();
	}

}