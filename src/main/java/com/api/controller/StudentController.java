package com.api.controller;


import java.util.*;

import org.hibernate.mapping.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.Entity.Student;
import com.api.Entity.Subject;
import com.api.repository.StudentRepository;
import com.api.repository.SubjectRepository;

@RestController

@CrossOrigin("*")
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private SubjectRepository subjectRepository;

    @PostMapping("/createStudent")
    public Student createStudent(@RequestBody Student student) {
    	
        return studentRepository.save(student);    
    }

    @GetMapping("/getAllStudents")
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    
    @DeleteMapping("/deleteStudent/{id}")
    public void deleteStudent(@PathVariable Long id) {
         studentRepository.deleteById(id);
    }
    
    @RequestMapping("/findById/{id}")
    public Optional<Student> findById(@PathVariable Long id) {
        return studentRepository.findById(id);
    }
    
    @PostMapping("/{studentId}/enroll/{subjectId}")
    public Student enrollInSubject(@PathVariable Long studentId, @PathVariable Long subjectId) {
        Student student = studentRepository.findById(studentId)
            .orElseThrow(() -> new RuntimeException("Student not found"));
        Subject subject = subjectRepository.findById(subjectId)
            .orElseThrow(() -> new RuntimeException("Subject not found"));

        student.getSubjects().add(subject);
        subject.getStudents().add(student);

        studentRepository.save(student);
        subjectRepository.save(subject);

        return student;
    }
    
    
}
