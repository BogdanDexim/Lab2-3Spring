package com.example.demo.Service;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.Student;
import com.example.demo.Repository.StudentRepository;

@Service
public class AdminService {
	private final StudentRepository studentRepository;
	
	 public AdminService(StudentRepository studentRepository) {
	     this.studentRepository = studentRepository;
	 }
	 
	 public void editStudent(int studId, String firstname, String secondname, String groupname){
		 Student student = studentRepository.findStudenById(studId);
		 student.setFirstname(firstname);
		 student.setSecondname(secondname);
		 student.setGroupname(groupname);
}
	    public void removeStudent(int studId){
	        studentRepository.removeStudent(studId);
	    }
	    public void newStudent( String firstname, String secondname, String groupname){
	    	studentRepository.addStudent(firstname, secondname, groupname);
	    }

}
