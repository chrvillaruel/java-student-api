package com.student.system.student;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository underTest;



    @Test
    void itShouldCheckWhenStudentEmailExists() {
        // given
        String email = "chan@gmail.com";
        Student student = new Student(
                "Jamila",
                email,
                Gender.FEMALE
        );

        underTest.save(student);

        // when
        List<Student> expected = underTest.findStudentByEmail(email);

        // then
        assertThat(expected.size() > 0).isTrue();
    }
}