package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.ApiResponse;
import com.app.dto.LoginDTO;
import com.app.exception.ResourseException;
import com.app.pojo.Student;
import com.app.repository.StudentRepository;


@Service
@Transactional
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentRepository repoObj;
	
	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return repoObj.findAll();
	}

	@Override
	public Student insertStudent(Student std) {
		// TODO Auto-generated method stub
		return repoObj.save(std);
	}

	@Override
	public String deleteById(Integer id) {
		// TODO Auto-generated method stub
		
		if(repoObj.existsById(id))
		{
			System.out.println("student found to delete !!");
			repoObj.deleteById(id);
			return "student deleted successfully !!";
		}
		
		return "invalid student trying to delete";
	}

	@Override
	public Student validateLogin(LoginDTO dto) {
		// TODO Auto-generated method stub
		return repoObj.findByEmailAndPassword(dto.getEmail(),dto.getPassword())
				.orElseThrow(()-> new ResourseException("invalid login cradentials !!"));
	}

	@Override
	public Student getSpecificStudent(Integer id) {
		// TODO Auto-generated method stub
		return repoObj.findById(id)
				.orElseThrow(()->new ResourseException("you have entered invalid student id !!"));
	}

	@Override
	public Student updateStudentDetails(Student detachedStd) {
		
		if (repoObj.existsById(detachedStd.getId())) {
			return repoObj.save(detachedStd);
		}
		throw new ResourseException("Invalid student Id : Updation Failed!!!!!!!!");
	}
	
}
