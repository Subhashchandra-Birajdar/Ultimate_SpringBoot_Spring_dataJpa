package com.app.controller;

import com.app.dto.SchoolDto;
import com.app.entity.School;
import com.app.repository.SchoolRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SchoolController {

    private final SchoolRepository schoolRepository;

    public SchoolController(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    @PostMapping("/create")
    public SchoolDto createStudent(@RequestBody SchoolDto schoolDto){
        School school = DtoToSchoolEntity(schoolDto); //toSchool
         this.schoolRepository.save(school);
            return schoolDto;
    }    // http://localhost:8080/create

    private School DtoToSchoolEntity(SchoolDto schoolDto) {
        var school = new School();
        school.setSchoolname(schoolDto.schoolname());
        return school;
    }

    private  SchoolDto toSchoolDto(School school){
        return new SchoolDto(school.getSchoolid(),school.getSchoolname());
    }

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
    public List<SchoolDto> getStudentall(){
        // List<School> studentList = this.schoolRepository.findAll();
        return  schoolRepository.findAll()
                .stream()
                .map(this::toSchoolDto)
                .collect(Collectors.toList());
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

