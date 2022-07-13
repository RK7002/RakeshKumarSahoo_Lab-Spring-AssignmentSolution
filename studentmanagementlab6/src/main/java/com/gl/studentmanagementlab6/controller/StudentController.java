package com.gl.studentmanagementlab6.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gl.studentmanagementlab6.entity.Role;
import com.gl.studentmanagementlab6.entity.Student;
import com.gl.studentmanagementlab6.entity.User;
import com.gl.studentmanagementlab6.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentService studentService;

	@RequestMapping("/list")
	public String listStudent(Model model) {
		List<Student> students = studentService.findAll();
		model.addAttribute("students", students);
		return "list-students";
	}

	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {

		Student student = new Student();
		model.addAttribute("Student", student);
		return "Student-form";
	}

	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("studentId") int id, Model model) {
		Student student = studentService.findById(id);
		model.addAttribute("Student", student);
		return "Student-form";
	}

	@RequestMapping("/save")
	public String save(@RequestParam("id") int id, @RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("course") String course,
			@RequestParam("country") String country) {

		Student student;

		if (id != 0) {
			student = studentService.findById(id);
			student.setFirstName(firstName);
			student.setLastName(lastName);
			student.setCourse(course);
			student.setCountry(country);
		} else {
			student = new Student(firstName, lastName, course, country);
		}

		studentService.save(student);
		return "redirect:/student/list";
	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("studentId") int id) {

		studentService.deleteById(id);
		return "redirect:/student/list";
	}

	@RequestMapping(value = "/403")
	public ModelAndView accessDenied(Principal user) {

		ModelAndView modelAndView = new ModelAndView();
		if (user != null) {
			modelAndView.addObject("msg", "Hey  " + user.getName() + " , You dont have permission to access this page");
		} else {
			modelAndView.addObject("msg", "You dont have permission to access this page");
		}
		modelAndView.setViewName("403");
		return modelAndView;

	}

}
