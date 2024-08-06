// src/main/java/com/api/Entity/Student.java
package com.api.Entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long student_id;
    
    private String name;

    
    @ManyToMany
    @JoinTable(
        name = "student_subject",  // Correct name for the join table
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "subject_id")
    )
    private Set<Subject> subjects;

    // Getters and Setters
    public Long getStudentId() {
        return student_id;
    }

    public void setStudentId(Long student_id) {
        this.student_id = student_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }

    public Student(Long student_id, String name, Set<Subject> subjects) {
        super();
        this.student_id = student_id;
        this.name = name;
        this.subjects = subjects;
    }

    public Student() {
        super();
    }

    @Override
    public String toString() {
        return "Student [student_id=" + student_id + ", name=" + name + "]";
    }
}
