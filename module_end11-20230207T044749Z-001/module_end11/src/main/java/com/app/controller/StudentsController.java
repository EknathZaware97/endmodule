package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.dto.LoginDTO;
import com.app.pojo.Student;
import com.app.service.StudentService;



@RestController
@RequestMapping("/students")
public class StudentsController {
	
	@Autowired
	private StudentService servObj;
	
	public StudentsController()
	{
		System.out.println("inside default ctctor of StudentsController ");
	}
	
	
	@PostMapping("/login")
	public Student validateLogin(@RequestBody LoginDTO dto)
	{
		return servObj.validateLogin(dto);
	}
	
	@GetMapping
	public List<Student> getAllStudents()
	{
		return servObj.getAllStudents();
	}
	
	@PostMapping
	public Student insertStudent(@RequestBody Student std)
	{
		return servObj.insertStudent(std);
	}
	
	@DeleteMapping("/{stdId}")
	public ApiResponse deleteById(@PathVariable Integer id)
	{
		return new ApiResponse(servObj.deleteById(id));
	}
	
	@GetMapping("/{stdId}")
	public Student getSpecificStudent(@PathVariable Integer id)
	{
		return servObj.getSpecificStudent(id);
	}
	
	@PutMapping
	public Student updateStudentDetails(@RequestBody Student detachedStd)
	{
	
		return servObj.updateStudentDetails(detachedStd);
	}

}
