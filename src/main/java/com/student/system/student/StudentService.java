package com.student.system.student;


import com.student.system.student.exception.BadRequestException;
import lombok.AllArgsConstructor;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@AllArgsConstructor
@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void addStudent(Student student) {

        List studentExists = studentRepository.findStudentByEmail(student.getEmail());

        // check if email is taken
        if (studentExists.size() > 0) {
            throw new BadRequestException("Email already in used.");
        }

        studentRepository.save(student);
    }

    public void deleteStudentById(Long studentId) {
        // check if email is taken
        studentRepository.deleteById(studentId);
    }


}
