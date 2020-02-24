package com.demo.qlhs.service;

import com.demo.qlhs.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAllStudent();
    void saveStudent(Student student);
    void deleteStudent(Long student_id);
    Student findById(Long student_id);
}
