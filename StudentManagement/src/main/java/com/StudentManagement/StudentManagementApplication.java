package com.StudentManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.StudentManagement.entity.Student;
import com.StudentManagement.repository.StudentRepo;

@SpringBootApplication
public class StudentManagementApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementApplication.class, args);
	}

	@Autowired
	private StudentRepo studentRepo;
	
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
//		Student s1 = new Student(1, "Samsher", "Pathaniya", "Patty@gmail.com", "Jammu");
//		studentRepo.save(s1);
//		
//		Student s2 = new Student(2, "Sartaj", "Gill", "Taj@gmail.com", "Punjab");
//		studentRepo.save(s2);
//		
//		Student s3 = new Student(3, "Bashir", "Khan", "Bash@gmail.com", "Kashmir");
//		studentRepo.save(s3);
//		
//		Student s4 = new Student(4, "Minal", "Thakur", "Minni@hotmail.com", "Rajastan");
//		studentRepo.save(s4);
	}

}
