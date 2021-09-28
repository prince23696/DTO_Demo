package com.DTO_Demo.DTO_DEMO.Repository;

import com.DTO_Demo.DTO_DEMO.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
