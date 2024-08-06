// src/main/java/com/api/Entity/Subject.java
package com.api.Entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subject_id;
    
    private String name;
    
    @ManyToMany(mappedBy = "subjects")
    @JsonBackReference
    private Set<Student> students;

    // Getters and Setters
    public Long getSubjectId() {
        return subject_id;
    }

    public void setSubjectId(Long subject_id) {
        this.subject_id = subject_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public Subject(Long subject_id, String name, Set<Student> students) {
        super();
        this.subject_id = subject_id;
        this.name = name;
        this.students = students;
    }

    public Subject() {
        super();
    }

    @Override
    public String toString() {
        return "Subject [subject_id=" + subject_id + ", name=" + name + "]";
    }
}
