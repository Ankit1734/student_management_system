package com.example.sms.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sms.model.Student;

@RestController
@RequestMapping("/students")
@CrossOrigin("*")
public class StudentController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping
    public ArrayList<Student> getStudent() {
      ArrayList<Student> students = new ArrayList<>();
       students.add(new Student(1, "Ankit", "BE"));
       students.add(new Student(2, "Harkirat", "ME"));
       students.add(new Student(3, "Aman", "MCA"));
       students.add(new Student(4,"Tushar","BCA"));
       students.add(new Student(5,"Aman","MCA"));
       students.add(new Student(6,"Priya","BCA"));

       return students;
    }
    @GetMapping("/mca")
    public List<Student> getMCAStudents(){
        return getStudent()
        .stream()
        .filter(student -> "MCA".equals(student.getCourse()))
        .collect(Collectors.toList());
    }
    @GetMapping("/count")
    public int countStudents(){
        String sql = "SELECT COUNT(*) FROM students";
        return jdbcTemplate.queryForObject(
            sql,
            Integer.class
    );
    }
}