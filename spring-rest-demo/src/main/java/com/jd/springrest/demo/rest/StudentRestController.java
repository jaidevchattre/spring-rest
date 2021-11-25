package com.jd.springrest.demo.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jd.springrest.demo.entity.Student;
import com.jd.springrest.demo.exception.StudentNotFoundException;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	private List<Student> studentList=new ArrayList<Student>();
	
	@PostConstruct
	public void loadData(){
	studentList.add(new Student("Ram","Charan"));
	studentList.add(new Student("Suresh","Prabhu"));
	studentList.add(new Student("Jai","Chattre"));
	studentList.add(new Student("John","Monte"));
	studentList.add(new Student("Akash","Dev"));
	}
	
	//define endpoint for "/students" return list of students
	
	@GetMapping("/students")
	public List<Student> getStudents(){

		return studentList;
	}
	
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		
		Optional<Student> student=Optional.ofNullable(studentList.get(studentId));
		if(!student.isPresent()) {
			throw new StudentNotFoundException("Student id not found- "+studentId);
		}
			
		return student.get();
	}
	

}
