package com.example.demo.Service;
import com.example.demo.Repository.Student;

import com.example.demo.Repository.StudentRepository;

import java.util.List;


import org.springframework.stereotype.Service;

@Service
public class UserService {
	private final StudentRepository studentRepository;
    public UserService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public List<Student> findStudentsByName(String secondname) {
    	return studentRepository.findStudentsByName(secondname);
    }
    public List<Student> findStudentsByGroup(String group) {
    	return studentRepository.findStudentsByGroup(group);
    }
}
