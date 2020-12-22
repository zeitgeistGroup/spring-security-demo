package com.example.demo.controllers;


import com.example.demo.models.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    private static final List<Student> STUDENTS_LIST = Arrays.asList(
            new Student(1, "ram"),
            new Student(2, "shyam"),
            new Student(3, "mohan")
            );


    @GetMapping(path = "{studentId}")
    public Student getStudent(@PathVariable("studentId") Integer studentId) {

        return STUDENTS_LIST.stream()
                             .filter(student-> studentId.equals(student.getStudentId()))
                             .findFirst()
                             .orElseThrow(()->new IllegalStateException(studentId+" dtudentId does not Exit"));


    }


}
