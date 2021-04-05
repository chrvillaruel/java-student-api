package com.student.system.student;

import com.student.system.student.exception.BadRequestException;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;
    private StudentService studentService;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        studentService = new StudentService(studentRepository);
    }


    @Test
    void itShouldGetAllStudents() {
        // When
        studentService.getAllStudents();

        // Then
         verify(studentRepository).findAll();
    }

    @Test
    void itCanCreateStudent() {
        // Given
        String email = "chan@gmail.com";
        Student student = new Student(
                "Jamila",
                email,
                Gender.FEMALE
        );

        // When
        studentService.createStudent(student);

        ArgumentCaptor<Student> studentArgumentCaptor = ArgumentCaptor.forClass(Student.class);

        verify(studentRepository)
                .save(studentArgumentCaptor.capture());

        Student capturedStudent = studentArgumentCaptor.getValue();

        // Then
        assertThat(capturedStudent).isEqualTo(student);

    }

    @Test
    @Disabled
     void deleteStudentById(Long studentId) {
    }

}