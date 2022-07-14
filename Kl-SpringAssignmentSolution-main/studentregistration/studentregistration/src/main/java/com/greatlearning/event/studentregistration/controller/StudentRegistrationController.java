package com.greatlearning.event.studentregistration.controller;

import com.greatlearning.event.studentregistration.model.Student;
import com.greatlearning.event.studentregistration.service.StudentRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import java.security.Principal;
import java.util.List;
@Controller
@Component
@RequestMapping("/event")
public class StudentRegistrationController {
    @Autowired
    private StudentRegistrationService registrationService;
    public StudentRegistrationController(StudentRegistrationService registratonService){
        this.registrationService = registratonService;
    }

    /****************/
    @RequestMapping("/showStudentform")
    public ModelAndView showStudentForm(){
        return new ModelAndView("student-form","command",new Student());
    }
    @RequestMapping(value="/registerStudent",method = RequestMethod.POST)
    public ModelAndView registerStudent(@ModelAttribute("student") Student theStudent){
        //write code to save  object

        System.out.println(theStudent.getId()+" "+theStudent.getFirstname()+
                " "+theStudent.getLastname()+" " +theStudent.getCourse()+" " +
                theStudent.getCountry());
        registrationService.registerStudent(theStudent);
        System.out.println("Student registered Successfully");
        //return new ModelAndView("empform","command",emp);
        return new ModelAndView("redirect:/event/list");
    }

    @GetMapping("/list")
    public String getAllRegisteredStudents(Model theModel){
        List<Student> theStudents = registrationService.getRegisteredStudents();
        theModel.addAttribute("students",theStudents);
        System.out.println("All registered students: \n"+theStudents.toString());
        return "list-students";
    }
    @RequestMapping(value="/delete")
    //@ResponseStatus(HttpStatus.NO_CONTENT)
    public ModelAndView deleteStudentById(@RequestParam("studentId") Long theId){
        registrationService.deleteStudent(theId);
        Model theModel = new RedirectAttributesModelMap();
        System.out.println("The student with Id "+theId+" is deleted successfully");
        return new ModelAndView("redirect:/event/list");
    }


    @RequestMapping(value="/updateForm")
    public String updateStudent(@RequestParam("studentId") Long theId, Model theModel) {
        Student theStudent = registrationService.getStudentbyId(theId);
        System.out.println("The details of student with id "+theId+" are updated from ");
        System.out.println(theStudent.toString());
        theModel.addAttribute("command",theStudent);
        return "edit-student-form";
    }
    @RequestMapping(value="/update",method = RequestMethod.POST)
    public String editsave(@ModelAttribute("student") Student student){
        registrationService.updateStudentDetails(student);
        System.out.println("to :"+student.toString());
        return ("redirect:/event/list");
    }
    @RequestMapping(value="/homePage")
    public String showHomePage() {
        return "index";
    }

    @RequestMapping(value = "/403")
    public ModelAndView accesssDenied(Principal user) {

        ModelAndView model = new ModelAndView();

        if (user != null) {
            model.addObject("msg", "Hi " + user.getName()
                    + ", you do not have permission to access this page!");
        } else {
            model.addObject("msg",
                    "You do not have permission to access this page!");
        }

        model.setViewName("403");
        return model;

    }


}
