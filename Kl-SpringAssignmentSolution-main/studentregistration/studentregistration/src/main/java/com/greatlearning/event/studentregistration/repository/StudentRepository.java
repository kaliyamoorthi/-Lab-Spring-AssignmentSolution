package com.greatlearning.event.studentregistration.repository;

import com.greatlearning.event.studentregistration.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
}
