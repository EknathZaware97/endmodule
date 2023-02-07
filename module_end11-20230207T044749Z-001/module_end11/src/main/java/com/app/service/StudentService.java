package com.app.service;

import java.util.List;

import com.app.dto.ApiResponse;
import com.app.dto.LoginDTO;
import com.app.pojo.Student;

public interface StudentService {

	List<Student> getAllStudents();

	Student insertStudent(Student std);

	String deleteById(Integer id);

	Student validateLogin(LoginDTO dto);

	Student getSpecificStudent(Integer id);

	Student updateStudentDetails(Student detachedStd);

}
