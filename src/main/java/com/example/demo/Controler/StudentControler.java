package com.example.demo.Controler;
import com.example.demo.Repository.Student;
import com.example.demo.Repository.StudentRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.demo.Service.UserService;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;


@Controller
public class StudentControler {
    private final StudentRepository studentRepository;

    public StudentControler(StudentRepository studentRepository, UserService userService) {
        this.studentRepository = studentRepository;

    }
    @PostMapping("/user")
    private String loginUser(Model model) {
        List<Student> studentList = studentRepository.findList();
        model.addAttribute("StudentList", studentList);
        return "userPage";
    }
    @GetMapping("/user/findNames")
    private String proceednames(String secondname, Model model){
        List<Student> studentList = studentRepository.findStudentsByName(secondname);
        model.addAttribute("StudentList", studentList);
        return "userpage";
    }
    @GetMapping("/user/findGroups")
    private String proceedgroups(String groupname, Model model){
        List<Student> studentList = studentRepository.findStudentsByGroup(groupname);
        model.addAttribute("StudentList", studentList);
        return "userpage";
    }
}
