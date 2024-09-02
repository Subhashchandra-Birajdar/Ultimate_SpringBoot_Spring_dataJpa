package com.app.controller;

import com.app.dto.StudentDto;
import com.app.dto.StudentResponseDto;
import com.app.entity.School;
import com.app.entity.Student;
import com.app.mapper.StudentMapper;
import com.app.repository.StudentRepository;
import com.app.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public StudentResponseDto postMethod(@Valid @RequestBody StudentDto studentDto){
        return studentService.postMethod(studentDto);
    }

    @GetMapping("/All/students")
    public List<StudentResponseDto> findAllStudent(){
        return studentService.findAllStudent();
    }

    @GetMapping("/students/signleStudent/{student-id}")
    public StudentResponseDto getSingleStudent(
            @PathVariable("student-id") Integer id
    ){
            return studentService.getSingleStudent(id);
    }

    @GetMapping("/students/{student-name}")
    public List<StudentResponseDto> getSingleByNameStudent(
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
    public Student updateStudent(@Valid @PathVariable Integer id, @RequestBody Student student1){
        return studentService.updateStudent(id,student1);
    }    // http://localhost:8080/studentstudent/update/2

    @ExceptionHandler(MethodArgumentNotValidException.class)
    //@ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<?> handle_method_argument_not_validException(
            MethodArgumentNotValidException e
    ){
        Map errors = new HashMap<String,String>();
        e.getBindingResult().getFieldErrors().forEach(error -> {
            String fieldName = error.getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        // return ResponseEntity.badRequest().body(errors);
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

}
