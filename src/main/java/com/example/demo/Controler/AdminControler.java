package com.example.demo.Controler;
import com.example.demo.Repository.Student;
import com.example.demo.Repository.StudentRepository;
import com.example.demo.Service.AdminService;
import java.util.List;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminControler {
	private final AdminService adminService;
	private final StudentRepository studentRepository;
	
    public AdminControler(StudentRepository studentRepository, AdminService adminService) {
        this.studentRepository = studentRepository;
        this.adminService = adminService;
    }
    @PostMapping("/admin")
    private String loginAdmin(Model model) {
        List<Student> studentList = studentRepository.findList();
        model.addAttribute("StudentList", studentList);
        return "deanpage";
    }
    
    @PostMapping("/admin/new")
    private String newStudent(){
        return "newStudent";
    }
    @PostMapping("/admin/new/proceed")
    private String proceed(String firstname, String secondname, String groupname, Model model){
        adminService.newStudent(firstname, secondname, groupname);
        List<Student> studentList = studentRepository.findList();
        model.addAttribute("StudentList", studentList);
        return "newStudent";
    }
    
    @PostMapping("/admin/remove")
    private String removeStudent(int studId, Model model){
        String student = studentRepository.findStudenById(studId).getFirstname();
        model.addAttribute("student", student);
        model.addAttribute("studId", studId);
        return "removeStudent";
    }
    
    @PostMapping("/admin/remove/proceed")
    private String proceed(int studId, Model model) {
        adminService.removeStudent(studId);
        List<Student> studentList = studentRepository.findList();
        model.addAttribute("StudentList", studentList);
        return "deanpage";
    }
    
    @PostMapping("/admin/edit")
    private String editStudent(int studId, Model model){
        Student student = studentRepository.findStudenById(studId);
        String firstname = student.getFirstname();
        String secondname = student.getSecondname();
        String groupname = student.getGroupname();
        model.addAttribute("studId", studId);
        model.addAttribute("firstname", firstname);
        model.addAttribute("secondname", secondname);
        model.addAttribute("groupname", groupname);
        return "editStudent";
    }
    
    @PostMapping("/admin/edit/proceed")
    private String proceed(int studId,String firstname, String secondname, String groupname, Model model){
        adminService.editStudent(studId, firstname, secondname, groupname);
        List<Student> studentList = studentRepository.findList();
        model.addAttribute("StudentList", studentList);
        return "deanpage";
    }
}
