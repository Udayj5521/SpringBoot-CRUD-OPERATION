package com;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

	@Autowired
	StudentService studentService;

	// Create post mapping that post the Student detail in the database
	@PostMapping("/save")
	public int save(@RequestBody Student student) {
		studentService.saveStudent(student);
		return student.getId();
	}

	// Create a get mapping that retrieves all the student detail from the database
	@GetMapping("/get")
	public List<Student> getAllStudent() {
		return studentService.getAllStudents();
	}

//	//creating a get mapping that retrieves the detail of a specific book  
	// Create a get Mapping that retrieves the detail of a Specific Student
	@GetMapping("/get/{id}")
	public Student getStudentById(@PathVariable int id) {
		return studentService.getStudentById(id);
	}

	// Create put Mapping that updated the Student detail
	@PutMapping("/update/{id}")
	public Student update(@RequestBody Student student, @PathVariable int id) {
		studentService.getStudentById(id);
		return studentService.saveStudent(student);
	}

	// Create a Delete Mapping that deleted a specific Student
	@DeleteMapping("/delete/{id}")
	public int deleteStudentById(@PathVariable int id) {
		return studentService.deleteById(id);
	}
}
