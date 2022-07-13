package com.gl.studentmanagementlab6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.studentmanagementlab6.entity.Student;
import com.gl.studentmanagementlab6.repository.StudentRepository;

@Service
public class StudentServiceImplementation implements StudentService{
	
	@Autowired
	private StudentRepository studentDao;

	@Override
	public List<Student> findAll() {
		return studentDao.findAll();
	}

	@Override
	public Student findById(int studentId) {
		return studentDao.findById(studentId).get();
	}

	@Override
	public void save(Student student) {
		studentDao.save(student);
	}

	@Override
	public void deleteById(int id) {
		studentDao.deleteById(id);
	}

}
