package com.example.new_interview.new_interview.service;

import com.example.new_interview.new_interview.model.Student;
import java.util.List;

public interface StudentService {
    Student getStudent(Long id);
    List<Student> getAllStudents();
    Student saveStudent(Student student);
    List<Student> saveAllStudents(List<Student> students);
    void deleteStudent(Long id);
    void deleteAllStudents(List<Long> ids);
    Student updateStudent(Student student);
    Student patchUpdateStudent(Long id, Student partialStudent);
}
