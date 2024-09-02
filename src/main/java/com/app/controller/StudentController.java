package com.app.controller;

import com.app.dto.StudentDto;
import com.app.dto.StudentResponseDto;
import com.app.entity.School;
import com.app.entity.Student;
import com.app.mapper.StudentMapper;
import com.app.repository.StudentRepository;
import com.app.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    // create end point
    @GetMapping("/")            // this is nothing but endpoint
    public String sayHello(){
        return "Hello from my first controller";    // httpStatus return 200 ok
    }      // what is the context path '/' ?

    @PostMapping("/students/create")
    public StudentResponseDto postMethod(@RequestBody StudentDto studentDto){
        return studentService.postMethod(studentDto);
    }

    @GetMapping("/All/students")
    public List<Student> findAllStudent(){
        return studentService.findAllStudent();
    }

    @GetMapping("/students/signleStudent/{student-id}")
    public Student getSingleStudent(
            @PathVariable("student-id") Integer id
    ){
            return studentService.getSingleStudent(id);
    }

    @GetMapping("/students/{student-name}")
    public List<Student> getSingleByNameStudent(
            @PathVariable("student-name") String name
    ){
    return studentService.getSingleByNameStudent(name);
    }

    @DeleteMapping("/student_delete/{student-id}")
    public String deleteSingleByidStudent(
            @PathVariable("student-id") Integer id
    ){
        return studentService.deleteSingleByidStudent(id);
    }

    @PutMapping("/student/update/{id}")
    public Student updateStudent(@PathVariable Integer id, @RequestBody Student student1){
        return studentService.updateStudent(id,student1);
    }    // http://localhost:8080/studentstudent/update/2
}
