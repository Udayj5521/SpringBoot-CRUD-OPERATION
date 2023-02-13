package com;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//It defines business loginc
@Service
public class StudentService {
	
	@Autowired
	StudentRepository sRepository;
	
	//Save a specific record by using the  save()
	public Student saveStudent(Student student)
	{
		return sRepository.save(student);
	}
	
	//Get all Student Record by using findAll()	
	public List<Student> getAllStudents() 
	{
		return sRepository.findAll();
	}
	
	//Get a specific record by using findById()
	public Student getStudentById(int id)
	{
		return sRepository.findById(id).get();
	}
	
	//Update a record
	public void updateStudentById(Student student,int id)
	{
		sRepository.save(student);
	}
	
	//Delete a specific record by using DeleteById()
	public int deleteById(int id)
	{
		sRepository.deleteById(id);
		return id;
	}
}
