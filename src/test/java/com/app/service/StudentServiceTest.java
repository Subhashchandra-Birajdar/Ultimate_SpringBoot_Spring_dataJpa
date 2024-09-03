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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

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

        // if user try to save to time same record then throw exception
        verify(studentMapper,Mockito.times(1)).dtoToStudent(dto);// dto to entity
        verify(studentRepository,Mockito.times(1)).save(student);//saved
        verify(studentMapper,Mockito.times(1)).studentResponseDto(savedstudent);//entity to repository
    }

   // Now test for findAll
    @Test
    public void should_all_student(){
        List<Student> students = new ArrayList<>();
        Student student = new Student("john","Doe","john@gmail.com",100);
        //mock the calls
        Mockito.when(studentRepository.findAll()).thenReturn(students);
        Mockito.when(studentMapper.studentResponseDto(any(Student.class)))
                .thenReturn(new StudentResponseDto(
                        "john","Doe","john@gmail.com")
                );
        //when
        List<StudentResponseDto> responseDtos = studentService.findAllStudent();

        //Then
        assertEquals(students.size(),responseDtos.size());
        //Mockito.verify(studentRepository,Mockito.times(1));
    }

    //Byid
    @Test
    public void should_return_student_by_id(){
        Integer studentId =1;
        Student student = new Student("john","Doe","john@gmail.com",100);

        //mock the calls
        Mockito.when(studentRepository.findById(studentId))
                .thenReturn(Optional.of(student));
        Mockito.when(studentMapper.studentResponseDto(any(Student.class)))
                .thenReturn(new StudentResponseDto(
                        "john","Doe","john@gmail.com")
                );
        //when
        StudentResponseDto dto = studentService.getSingleStudent(studentId);

        //then
        assertEquals(dto.firstname(),dto.firstname());
        assertEquals(dto.lastname(),dto.lastname());
        assertEquals(dto.email(),dto.email());

    }

    //Findbyname
    @Test
    public void should_by_name(){
        String studentName = "john";
        List<Student> students = new ArrayList<>();
        Student student = new Student(
                "john",
                "Doe",
                "john@gmail.com",
                100);
        //mock the calls
        Mockito.when(studentRepository.findAllByFirstnameContaining(studentName))
                .thenReturn(students);
        Mockito.when(studentMapper.studentResponseDto(any(Student.class)))
                .thenReturn(new StudentResponseDto(
                        "john",
                        "Doe",
                        "john@gmail.com")
                );
        //when
        var responseDto = studentService.getSingleByNameStudent(studentName);

        //Then
        assertEquals(students.size(),responseDto.size());
        verify(studentRepository,Mockito.times(1)).findAllByFirstnameContaining(studentName);
    }

}


