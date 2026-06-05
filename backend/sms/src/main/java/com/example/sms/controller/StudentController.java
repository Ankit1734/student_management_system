package com.example.sms.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sms.model.Student;

@RestController
@RequestMapping("/students")
@CrossOrigin("*")
public class StudentController {

    @GetMapping
    public ArrayList<Student> getStudent() {
      ArrayList<Student> students = new ArrayList<>();
       students.add(new Student(1, "Ankit", "BE"));
       students.add(new Student(2, "Harkirat", "ME"));
       students.add(new Student(3, "Aman", "MCA"));
       students.add(new Student(4,"Tushar","BCA"));
       students.add(new Student(5,"Aman","BCA"));
       students.add(new Student(6,"Priya","BCA"));

       return students;
    }
    @GetMapping("/bca")
    public List<Student> getBcaStudents(){
        return getStudent()
        .stream()
        .filter(student -> "BCA".equals(student.getCourse()))
        .collect(Collectors.toList());
    }
}