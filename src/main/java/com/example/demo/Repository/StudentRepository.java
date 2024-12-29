package com.example.demo.Repository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;



@Repository
public class StudentRepository {
	
	private List<Student> studentlist;
	public int id = 1;
	
	public StudentRepository() {
		studentlist = new ArrayList<>();
		studentlist.add(new Student(id++,"Олександр","Шевченко","ІО-21"));
		studentlist.add(new Student(id++,"Марія","Гончаренко","ІО-21"));
		studentlist.add(new Student(id++,"Іван","Бойко","ІО-21"));
		studentlist.add(new Student(id++,"Анастасія ","Лисенко","ІО-22"));
		studentlist.add(new Student(id++,"Софія ","Кравченко","ІО-22"));
		studentlist.add(new Student(id++,"Дмитро ","Шевченко","ІО-23"));
		studentlist.add(new Student(id++,"Марія","Кравченко","ІО-23"));
		studentlist.add(new Student(id++,"Артем ","Соколовський","ІО-24"));
		studentlist.add(new Student(id++,"Ольга ","Шевченко","ІО-24"));
		studentlist.add(new Student(id++,"Катерина ","Романюк","ІО-24"));
	
		
	}
	
	public void addStudent(String firstname, String secondname, String groupname) {
		Student student = new Student(id++, firstname, secondname, groupname);
		studentlist.add(student);
	}
	    public void removeStudent(int id) {
	    	studentlist.removeIf(student -> student.getStudId() == id);
	}
	    
	    
	    public Student findStudenById(int id){
	        for (Student student : studentlist) {
	            if (student.getStudId() == id){
	                return student;
	            }
	        }
	        return null;
	    }
	    
	    public List<Student> findStudentsByName(String secondname) {
	        List<Student> result = new ArrayList<>();
	        
	        for (Student student : studentlist) {
	            if (student.getSecondname().equalsIgnoreCase(secondname)) {
	                result.add(student);
	            }
	        }
	        
	        return result;
	    }
	    public List<Student> findStudentsByGroup(String groupname) {
	        List<Student> result = new ArrayList<>();
	        
	        for (Student student : studentlist) {
	            if (student.getGroupname().equalsIgnoreCase(groupname)) {
	                result.add(student);
	            }
	        }
	        
	        
	        return result;
	    }
	    
	    public List<Student> findList() {
	        return studentlist;
	    }
	    
	
}
