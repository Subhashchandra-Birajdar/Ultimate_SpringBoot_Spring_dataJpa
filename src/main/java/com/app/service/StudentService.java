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

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository ;
    @Autowired
    private StudentMapper mapper;

    @PostMapping("/students/create")
    public StudentResponseDto postMethod(@RequestBody StudentDto studentDto){
        Student student = mapper.dtoToStudent(studentDto);// dto to student convert
        Student savedStudent = studentRepository.save(student);
        return mapper.studentResponseDto(savedStudent);
    }

    @GetMapping("/All/students")
    public List<Student> findAllStudent(){
        return studentRepository.findAll();
        //return all students
    }

    @GetMapping("/students/signleStudent/{student-id}")
    public Student getSingleStudent(
            @PathVariable("student-id") Integer id
    ){
        return studentRepository.findById(id).orElse(new Student());
        // if student found the return student otherwise return empty student
    }

    @GetMapping("/students/{student-name}")
    public List<Student> getSingleByNameStudent(
            @PathVariable("student-name") String name
    ){
        return studentRepository.findAllByFirstnameContaining(name);
        // if student found the return student otherwise return empty student
    }

    @DeleteMapping("/student_delete/{student-id}")
    public String deleteSingleByidStudent(
            @PathVariable("student-id") Integer id
    ){
        studentRepository.deleteById(id);
        return "Student is deleted";
    }

    @PutMapping("/student/update/{id}")
    public Student updateStudent(@PathVariable Integer id, @RequestBody Student student1){
        Student student = this.studentRepository.findById(id).orElse(new Student());
        //Student student = new Student();
        student.setFirstname(student1.getFirstname());
        student.setLastname(student1.getLastname());
        student.setEmail(student1.getEmail());
        student.setAge(student1.getAge());
        return this.studentRepository.save(student);
    }    // http://localhost:8080/studentstudent/update/2

}

