package com.example.demo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entitiy.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    
    // define endpoint for "/students" - return a list of students

    @GetMapping("/students")
    public List<Student> getStudents() {
        List<Student> theStudents = new ArrayList<>();
        
        theStudents.add(new Student("Furkan","Kaan"));
        theStudents.add(new Student("Ahmet","Bilge"));
        theStudents.add(new Student("Ayten","Sena"));
        theStudents.add(new Student("Gulten","Suha"));

        return theStudents;
    }
}
