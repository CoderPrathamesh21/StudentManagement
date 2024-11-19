package com.StudentManagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.StudentManagement.entity.Student;
import com.StudentManagement.repository.StudentRepo;

@Service
public class StudentServiceImpl implements StudentService {
	
	private StudentRepo studentRepo;
	
	public StudentServiceImpl(StudentRepo studentRepo) {
		super();
		this.studentRepo = studentRepo;
	}

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return studentRepo.findAll();
	}

	@Override
	public Student saveStudent(Student student) {
		// TODO Auto-generated method stub
		return studentRepo.save(student);
	}

	@Override
	public Student getStudentById(int id) {
		
		return studentRepo.findById(id).get();
	}

	@Override
	public Student updateStudent(Student student) {
		
		return studentRepo.save(student);
	}

	@Override
	public void deleteStudentById(int id) {
		
		studentRepo.deleteById(id);
		
	}

}
