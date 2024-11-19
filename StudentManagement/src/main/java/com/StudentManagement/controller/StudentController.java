package com.StudentManagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.StudentManagement.entity.Student;
import com.StudentManagement.service.StudentService;

@Controller
public class StudentController {
	
	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	//handler to handle list of students and return model view
	
	@GetMapping("/students")
	public String listOfStudents(Model model) {
		
		model.addAttribute("students", studentService.getAllStudents());
		
		return "students";
	}
	
	@GetMapping("/students/new")
	public String newStudentForm(Model model) {
		
		// create student object to hold form data
		Student student = new Student();
		
		model.addAttribute("student", student);
		
		return "create_student";
		
	}
	
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		
		studentService.saveStudent(student);
		
		return "redirect:/students";
		
	}
	
	@GetMapping("/students/edit/{id}")
	public String editStudent(@PathVariable int id, Model model) {
		
		model.addAttribute("student", studentService.getStudentById(id));
		
		return "update_student";
	}
	
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable int id, @ModelAttribute("student") Student student) {
		
		Student existingStudent = studentService.getStudentById(id);
		
		//get student data from db by id
		existingStudent.setId(id);
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());
		existingStudent.setAddress(student.getAddress());
		
		//save updated student data
		studentService.updateStudent(existingStudent);
		return "redirect:/students";
		
	}
	
	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable int id) {
		studentService.deleteStudentById(id);
		return "redirect:/students";
	}
	
	

}
