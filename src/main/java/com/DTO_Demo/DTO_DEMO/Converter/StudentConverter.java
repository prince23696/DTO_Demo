package com.DTO_Demo.DTO_DEMO.Converter;

import com.DTO_Demo.DTO_DEMO.DTO.StudentDto;
import com.DTO_Demo.DTO_DEMO.Entity.Student;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StudentConverter {

    public StudentDto entityToDto(Student student) {

        StudentDto studentDto = new StudentDto();
        studentDto.setId(student.getId());
        studentDto.setName(student.getName());
        studentDto.setUserName(student.getUserName());
        studentDto.setPassword(student.getPassword());
        return studentDto;
    }

    public Student dtoToEntity(StudentDto studentDto) {

        Student student = new Student();
        student.setId(studentDto.getId());
        student.setName(studentDto.getName());
        student.setUserName(studentDto.getUserName());
        student.setPassword(studentDto.getPassword());
        return student;
    }

    public List<StudentDto> entityToDto(List<Student> student) {

        return student.stream().map(x -> entityToDto(x)).collect(Collectors.toList());

    }

    public List<Student> dtoToEntity(List<StudentDto> dto) {

        return dto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
    }
}