package com.example.sms.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.sms.dto.StudentRequestDTO;
import com.example.sms.exception.StudentNotFoundException;
import com.example.sms.model.Student;
import com.example.sms.repository.StudentRepository;
  
@Service
public class StudentService {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    private StudentRepository repository;
    
    public  String getStudentInfo(){
        return "Service is working";
    }
    public Integer getStudentCount() {

        String sql = "SELECT COUNT(*) FROM students";

        return jdbcTemplate.queryForObject(sql,Integer.class);

    }
    public List<Student> getAllStudents() {

        return repository.findAll();

    }
    public  Student saveStudent(Student students) {
        return repository.save(students);
    }
    public Student getStudentById(Integer id){
        return repository
           .findById(id)
           .orElseThrow(() -> new StudentNotFoundException("Student not found with id: " + id));
    }
    public Student addStudent(StudentRequestDTO dto) {

    Student student = new Student();
    
    student.setName(dto.getName());
    student.setCourse(dto.getCourse());

    return repository.save(student);
}
    
}
