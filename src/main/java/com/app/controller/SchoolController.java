package com.app.controller;

import com.app.dto.SchoolDto;
import com.app.entity.School;
import com.app.mapper.SchoolMapper;
import com.app.repository.SchoolRepository;
import com.app.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SchoolController {

    @Autowired
    private SchoolService schoolService;

    @PostMapping("/create")
    public SchoolDto createStudent(@RequestBody SchoolDto schoolDto){
            return schoolService.createSchool(schoolDto);
    }    // http://localhost:8080/create


    @GetMapping("/getone/{id}")
    public School getStudent(@PathVariable Integer id){
        return schoolService.getSchoolById(id);
    }    // http://localhost:8080/getone/6

    @GetMapping("/school-searchname/{sname}")
    public List<School> getStudent(@PathVariable String sname){
        return schoolService.getSchool(sname);
    }    // http://localhost:8080/student-searchname/su

    @GetMapping("/getall")
    public List<SchoolDto> getStudentall(){
        // List<School> studentList = this.schoolRepository.findAll();
        return  schoolService.getSchoolall();
    }    // http://localhost:8080/getall

    @PutMapping("/update/{id}")
    public School updateStudent(@PathVariable Integer id, @RequestBody School school1){
        return schoolService.updateSchool(id,school1);
    }    // http://localhost:8080/update/6

    @DeleteMapping("/delete/{id}")
    public void studentStudent(@PathVariable Integer id){
        schoolService.deleteSchool(id);
    }    // http://localhost:8080/delete/6
}

