package com.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.Entity.Subject;
import com.api.repository.SubjectRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("/subjects")
public class SubjectController {

    @Autowired
    private SubjectRepository subjectRepository;
    
    @PostMapping("/createSubject")
    public Subject createSubject(@RequestBody Subject subject) {
    	Subject sub = new Subject();
        sub.setName(subject.getName());
        return subjectRepository.save(sub);
    }

    @GetMapping("/{id}")
    public Subject getSubject(@PathVariable Long id) {
    	return subjectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Subject not found"));
    }
    
    @DeleteMapping("/{id}")
    public void deleteSubject(@PathVariable Long id) {
    	  if (subjectRepository.existsById(id)) {
              subjectRepository.deleteById(id);
          } else {
              throw new RuntimeException("Subject not found");
          }
    }
    @GetMapping("/getAllSubjects")
    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }
}

