package com.demo.qlhs.rest;

import com.demo.qlhs.model.Student;
import com.demo.qlhs.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class StudentRestController {
    @Autowired
    private StudentService studentService;
    @GetMapping("students")
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> students = studentService.findAllStudent();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @PostMapping("students")
    public ResponseEntity<Student> createStudent(@RequestBody Student student, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        studentService.saveStudent(student);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PutMapping("students")
    public ResponseEntity<Student> editStudent(@RequestBody Student student, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        studentService.saveStudent(student);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @DeleteMapping("students/{student_id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long student_id){
        studentService.deleteStudent(student_id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("students/{student_id}")
    public ResponseEntity<Student> findStudentById(@PathVariable Long student_id){
        Student student = studentService.findById(student_id);
        if (student == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(student, HttpStatus.OK);
    }
}
