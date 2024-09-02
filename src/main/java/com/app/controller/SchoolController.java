package com.app.controller;

import com.app.entity.School;
import com.app.repository.SchoolRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SchoolController {

    private final SchoolRepository schoolRepository;

    public SchoolController(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    @PostMapping("/create")
    public School createStudent(@RequestBody School school){
        return this.schoolRepository.save(school);
    }    // http://localhost:8080/create

    @GetMapping("/getone/{id}")
    public School getStudent(@PathVariable Integer id){
        School school = this.schoolRepository.findById(id).orElse(new School());
        //Student student = new Student();
        return school;
    }    // http://localhost:8080/getone/6

    @GetMapping("/school-searchname/{sname}")
    public List<School> getStudent(@PathVariable String sname){
        List<School> allByfirstname = this.schoolRepository.findAllByschoolnameContaining(sname);
        //Student student = new Student();
        return allByfirstname;
    }    // http://localhost:8080/student-searchname/su

    @GetMapping("/getall")
    public List<School> getStudentall(){
        List<School> studentList = this.schoolRepository.findAll();
        //Student student = new Student();
        return studentList;
    }    // http://localhost:8080/getall

    @PutMapping("/update/{id}")
    public School updateStudent(@PathVariable Integer id, @RequestBody School school1){
        School school = this.schoolRepository.findById(id).orElse(new School());
        //Student school = new Student();
        school.setSchoolname(school1.getSchoolname());
        return this.schoolRepository.save(school);
    }    // http://localhost:8080/update/6

    @DeleteMapping("/delete/{id}")
    public void studentStudent(@PathVariable Integer id){
        School Sc = this.schoolRepository.findById(id).orElse(new School());
        //Student student = new Student();
        this.schoolRepository.delete(Sc);
    }    // http://localhost:8080/delete/6
}

