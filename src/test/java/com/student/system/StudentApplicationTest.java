package com.student.system;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest class StudentApplicationTest {
    Calucator calucator = new Calucator();

    @Test
    void itShouldAddTwoNumbers(){
        // Given
        int numberOne = 20;
        int numberTwo = 30;

        // When
        int result = calucator.add(numberOne, numberTwo);

        // then
        assertThat(result).isEqualTo(50);
    }

    @Test
    void contextLoads() {
        Assertions.assertTrue(true);
    }

    class Calucator {
        int add(int firstNumber, int secondNumber) {
            return firstNumber + secondNumber;
        }
    }
}