package com.example.sms.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sms.dto.StudentRequestDTO;
import com.example.sms.dto.StudentResponseDTO;
import com.example.sms.model.Student;
import com.example.sms.service.StudentService;

@RestController
@RequestMapping("/students")
@CrossOrigin("*")
public class StudentController {
    

    @Autowired
    private StudentService service;


  //  @GetMapping
   // public ArrayList<Student> getStudent() {
     // ArrayList<Student> students = new ArrayList<>();
      // students.add(new Student(1, "Ankit", "BE"));
       //students.add(new Student(2, "Harkirat", "ME"));
       //students.add(new Student(3, "Aman", "MCA"));
       //students.add(new Student(4,"Tushar","BCA"));
       //students.add(new Student(5,"Aman","MCA"));
       //students.add(new Student(6,"Priya","BCA"));

      // return students;
    //}
    @GetMapping("/mca")
    public List<Student> getMCAStudents(){
        return getStudents()
        .stream()
        .filter(student -> "MCA".equals(student.getCourse()))
        .collect(Collectors.toList());
    }
    @GetMapping("/count")
    public int countStudents(){
     return service.getStudentCount();
    }
    @GetMapping("/message")
    public String getMessage() {
        return service.getStudentInfo();
    }
    @GetMapping
    public List<Student> getStudents(){
        return service.getAllStudents();
    }
    //@PostMapping
    //public Student addStudent(@RequestBody Student student) {
    //return service.saveStudent(student);
//}
    @GetMapping("/{id}")
    public ResponseEntity<?> getStudent(@PathVariable Integer id){
      
        Student student = service.getStudentById(id);

        StudentResponseDTO response = new StudentResponseDTO(
                    student.getId(),
                    student.getName(),
                    student.getCourse()
                   
            );
            return ResponseEntity.ok(response); 
}
    @PostMapping
    public ResponseEntity<?> addStudent(@RequestBody StudentRequestDTO dto) {

        Student student = service.addStudent(dto);

        return ResponseEntity.ok(student);
}

}
