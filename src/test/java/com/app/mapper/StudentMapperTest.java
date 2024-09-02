package com.app.mapper;

import com.app.dto.StudentDto;
import com.app.dto.StudentResponseDto;
import com.app.entity.Student;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class StudentMapperTest {

    StudentMapper mapper = new StudentMapper();

    @BeforeEach
    void setUp() {
        System.out.println("Inside the before each method");
    }

    @Test
    public void testMethod1(){
        System.out.println("My first test method");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Inside the after each method");
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("Inside the before all class each method");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Inside the after all class each method");
    }

    @Test
    public void shouldMapStudentDtoToStudent(){
        StudentDto dto = new StudentDto(
                "John",
                "sham",
                "john@gmail.com",
                1,
                2
        );
        Student student = mapper.dtoToStudent(dto);
        //Assertions.assertEquals(dto.firstname(),student.getFirstname());
        assertEquals(dto.firstname(),student.getFirstname());
        assertEquals(dto.lastname(),student.getLastname());
        assertEquals(dto.email(),student.getEmail());
        // here we want to make sure school not be null
        assertNotNull(student.getSchool());
        assertEquals(dto.schoolid(),student.getSchool().getSchoolid());

    }

    // task is about entity to dto
    @Test
    public void shouldMapStudentToStudentResponseDto(){
        Student student = new Student();
        //when
        StudentResponseDto studentResponseDto = mapper.studentResponseDto(student);

        //then
        assertEquals(studentResponseDto.firstname(),student.getFirstname());
        assertEquals(studentResponseDto.lastname(),student.getLastname());
        assertEquals(studentResponseDto.email(),student.getEmail());
    }

    @Test
    public void should_throw_Nullpointer_Exception_map_studentDto_to_student_when_StudentDto_is_null(){
        // check it will not or not
        var exp= assertThrows(NullPointerException.class,()->mapper.dtoToStudent(null));
        assertEquals("The student be null",exp.getMessage());
    }


}

