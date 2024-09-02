package com.app.service;

import com.app.dto.StudentDto;
import com.app.dto.StudentResponseDto;
import com.app.entity.Student;
import com.app.mapper.StudentMapper;
import com.app.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository ;
    @Autowired
    private StudentMapper mapper;

    public StudentResponseDto postMethod( StudentDto studentDto){
        Student student = mapper.dtoToStudent(studentDto);// dto to student convert
        Student savedStudent = studentRepository.save(student);
        return mapper.studentResponseDto(savedStudent);
    }

    public List<StudentResponseDto> findAllStudent(){
        return studentRepository.findAll().stream().map(mapper::studentResponseDto).collect(Collectors.toList());
        //return all students
    }


    public StudentResponseDto getSingleStudent(Integer id
    ){
        return studentRepository.findById(id).map(mapper::studentResponseDto).orElse(null);
        // if student found the return student otherwise return empty student
    }


    public List<StudentResponseDto> getSingleByNameStudent(String name){
        return studentRepository.findAllByFirstnameContaining(name)
                .stream().map(mapper::studentResponseDto).collect(Collectors.toList());
        // if student found the return student otherwise return empty student
    }

    public String deleteSingleByidStudent(Integer id){
        studentRepository.deleteById(id);
        return "Student is deleted";
    }

    public Student updateStudent(Integer id, Student student1){
        Student student = this.studentRepository.findById(id).orElse(new Student());
        //Student student = new Student();
        student.setFirstname(student1.getFirstname());
        student.setLastname(student1.getLastname());
        student.setEmail(student1.getEmail());
        student.setAge(student1.getAge());
        return this.studentRepository.save(student);
    }    // http://localhost:8080/studentstudent/update/2
}

