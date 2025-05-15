package com.example.new_interview.new_interview.service;

import com.example.new_interview.new_interview.model.Teacher;
import java.util.List;

public interface TeacherService {
    Teacher getTeacher(Long id);
    List<Teacher> getAllTeachers();
    Teacher saveTeacher(Teacher teacher);
    List<Teacher> saveAllTeachers(List<Teacher> teachers);
    void deleteTeacher(Long id);
    void deleteAllTeachers(List<Long> ids);
    Teacher updateTeacher(Teacher teacher);
    Teacher patchUpdateTeacher(Long id, Teacher partialTeacher);
} 