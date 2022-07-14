package com.greatlearning.event.studentregistration.service;

import com.greatlearning.event.studentregistration.model.Student;
import com.greatlearning.event.studentregistration.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentRegistrationService {
    @Autowired
    private StudentRepository studentRepository;
    public StudentRegistrationService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public Student registerStudent(Student student){
        return this.studentRepository.save(student);
    }
    public List<Student> getRegisteredStudents()
    {
        return this.studentRepository.findAll();

    }
    public Student getStudentbyId(Long id){
        Optional<Student> result = studentRepository.findById(id);

        Student theStudent = null;

        if (result.isPresent()) {
            theStudent = result.get();
        }
        else {
            // we didn't find the employee
            throw new IllegalArgumentException("Did not find Student with id - " + id);
        }

        return theStudent;
    }
    public Student updateStudentDetails(Student student){
//        Student student = getStudentbyId(id);
        return this.studentRepository.save(student);
    }
    public void deleteStudent(Long id){
        System.out.println("Student with the following Id is deleted: "+ id);
        this.studentRepository.delete(getStudentbyId(id));
        return;
    }


}
