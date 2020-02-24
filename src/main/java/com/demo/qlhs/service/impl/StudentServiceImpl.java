package com.demo.qlhs.service.impl;

import com.demo.qlhs.model.Student;
import com.demo.qlhs.repository.StudentRepository;
import com.demo.qlhs.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> findAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long student_id) {
        Student student = findById(student_id);
        if (student != null){
            studentRepository.delete(student);
        }
    }

    @Override
    public Student findById(Long student_id) {
        Optional<Student> student = studentRepository.findById(student_id);
        if (student.isPresent()){
            return student.get();
        }
        return null;
    }
}
