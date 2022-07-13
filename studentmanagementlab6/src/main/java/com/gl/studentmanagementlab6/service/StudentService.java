package com.gl.studentmanagementlab6.service;

import java.util.List;

import com.gl.studentmanagementlab6.entity.Student;

public interface StudentService {
	
	public List<Student> findAll();
	public Student findById(int studentId);
	public void save(Student student);
	public void deleteById(int id);
}
