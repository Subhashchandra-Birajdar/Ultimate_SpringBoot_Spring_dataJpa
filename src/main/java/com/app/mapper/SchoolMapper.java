package com.app.mapper;

import com.app.dto.SchoolDto;
import com.app.entity.School;

public class SchoolMapper {

    public School DtoToSchoolEntity(SchoolDto schoolDto) {
        var school = new School();
        school.setSchoolname(schoolDto.schoolname());
        return school;
    }

    public  SchoolDto toSchoolDto(School school){
        return new SchoolDto(school.getSchoolid(),school.getSchoolname());
    }

}
