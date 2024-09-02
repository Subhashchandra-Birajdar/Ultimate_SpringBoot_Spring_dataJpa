package com.app.service;

import com.app.dto.StudentDto;
import com.app.dto.StudentResponseDto;
import com.app.entity.Student;
import com.app.mapper.StudentMapper;
import com.app.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {

    //which service we want to test
    @InjectMocks //org.mocks
    private StudentService studentService;

    //declare the dependency
    @Mock //org.mock
    private StudentRepository studentRepository;

    @Mock
    private StudentMapper studentMapper;

    //now we have to tell spring start mock for this class
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // here mock start // set up the mock here
    }

    // now analyse the save method and perform
    @Test
    public void should_successfully_save_a_student(){
        StudentDto dto = new StudentDto(
                "john",
                "Doe",
                "john@gmail.com",
                100,
                1
        );

        // it will come from mapping
        Student student = new Student(
                "john",
                "Doe",
                "john@gmail.com",
                100);

        Student savedstudent = new Student(
                "john",
                "Doe",
                "john@gmail.com",
                100);

        savedstudent.setSid(1);

        //mock the calls, call every call that uses the dependency
        Mockito.when(studentMapper.dtoToStudent(dto))
                .thenReturn(student);
        Mockito.when(studentRepository.save(student))
                .thenReturn(savedstudent);
        Mockito.when(studentMapper.studentResponseDto(savedstudent))
                .thenReturn(new StudentResponseDto("john","Doe","john@gmail.com"));

        //when
        StudentResponseDto responseDto = studentService.postMethod(dto);

        //then
        assertEquals(dto.firstname(),responseDto.firstname());
        assertEquals(dto.lastname(),responseDto.lastname());
        assertEquals(dto.email(),responseDto.email());
    }
}