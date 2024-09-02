package com.app.service;

import com.app.dto.SchoolDto;
import com.app.entity.School;
import com.app.mapper.SchoolMapper;
import com.app.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolService {

    @Autowired
    private SchoolRepository schoolRepository;

    @Autowired
    private SchoolMapper mapper;

    public SchoolDto createSchool(SchoolDto schoolDto){
        School school = mapper.DtoToSchoolEntity(schoolDto); //toSchool
        this.schoolRepository.save(school);
        return schoolDto;
    }    // http://localhost:8080/create


    public School getSchoolById(Integer id){
        School school = this.schoolRepository.findById(id).orElse(new School());
        //Student student = new Student();
        return school;
    }    // http://localhost:8080/getone/6

    public List<School> getSchool(String sname){
        List<School> allByfirstname = this.schoolRepository.findAllByschoolnameContaining(sname);
        //Student student = new Student();
        return allByfirstname;
    }    // http://localhost:8080/student-searchname/su

    public List<SchoolDto> getSchoolall(){
        // List<School> studentList = this.schoolRepository.findAll();
        return  schoolRepository.findAll()
                .stream()
                .map(mapper::toSchoolDto)
                .collect(Collectors.toList());
    }    // http://localhost:8080/getall

    public School updateSchool(Integer id, School school1){
        School school = this.schoolRepository.findById(id).orElse(new School());
        //Student school = new Student();
        school.setSchoolname(school1.getSchoolname());
        return this.schoolRepository.save(school);
    }    // http://localhost:8080/update/6

    public void deleteSchool(Integer id){
        School Sc = this.schoolRepository.findById(id).orElse(new School());
        //Student student = new Student();
        this.schoolRepository.delete(Sc);
    }    // http://localhost:8080/delete/6
}

