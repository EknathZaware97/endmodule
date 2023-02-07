package com.app.pojo;

import java.time.LocalDate;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name="std_tbl")
public class Student extends BaseEntity{
	
	@Column(length=30)
	private String firstName;
	@Column(length=30)
	private String lastName;
	@Column(length=30,unique=true)
	private String email;
	@Column(length=30)
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;
	@Column(length=30)
	private String course;
	private LocalDate joinDate;
	private double marks;
	
	
	public Student() {
		super();
	}
	
	
	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", password="
				+ password + ", course=" + course + ", joinDate=" + joinDate + ", marks=" + marks + "]";
	}


	public Student(String firstName, String lastName, String email, String password, String course, LocalDate joinDate,
			double marks) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.course = course;
		this.joinDate = joinDate;
		this.marks = marks;
	}


	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public LocalDate getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(LocalDate joinDate) {
		this.joinDate = joinDate;
	}
	public double getMarks() {
		return marks;
	}
	public void setMarks(double marks) {
		this.marks = marks;
	}
	

}
