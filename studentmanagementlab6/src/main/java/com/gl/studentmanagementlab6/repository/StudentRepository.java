package com.gl.studentmanagementlab6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gl.studentmanagementlab6.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

}
