package com.DTO_Demo.DTO_DEMO.Controller;

import com.DTO_Demo.DTO_DEMO.Converter.StudentConverter;
import com.DTO_Demo.DTO_DEMO.DTO.StudentDto;
import com.DTO_Demo.DTO_DEMO.Entity.Student;
import com.DTO_Demo.DTO_DEMO.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    StudentConverter converter;

    @GetMapping("/getStudentDtos")
    public List<StudentDto> findAll() {
        List<Student> findAll = studentRepository.findAll();
        return converter.entityToDto(findAll);
    }

    @GetMapping("/getStudents")
    public List<Student> findsAll() {
        List<Student> students = studentRepository.findAll();
        return students;
    }

    @GetMapping("/find/{id}")
    public StudentDto findById(@PathVariable int id) {
        Student orElse = studentRepository.findById(id).orElse(null);
        return converter.entityToDto(orElse);

    }

    @PostMapping("/saveStudent")
    public StudentDto save(@RequestBody StudentDto dto) {

        Student student = converter.dtoToEntity(dto);
        student = studentRepository.save(student);
        return converter.entityToDto(student);
    }
}