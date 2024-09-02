package com.app.mapper;

import com.app.dto.StudentDto;
import com.app.dto.StudentResponseDto;
import com.app.entity.School;
import com.app.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    public Student dtoToStudent(StudentDto studentdto){       // DTO method
        var student = new Student();
        student.setFirstname(studentdto.firstname()); // used record here studentdto
        student.setLastname(studentdto.lastname());
        student.setEmail(studentdto.email());

        var school = new School();
        school.setSchoolid(studentdto.schoolid()); // school id from school entity

        student.setSchool(school);
        return student;
    }

    public StudentResponseDto studentResponseDto(Student student){
        return new StudentResponseDto(
                student.getFirstname(),
                student.getLastname(),
                student.getEmail()
        );
    }

}
