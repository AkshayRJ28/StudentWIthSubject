package com.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.Entity.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
