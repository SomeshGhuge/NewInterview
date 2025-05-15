package com.example.new_interview.new_interview.controller;

import com.example.new_interview.new_interview.model.Teacher;
import com.example.new_interview.new_interview.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping("/{id}")
    public ResponseEntity<Teacher> getTeacher(@PathVariable Long id) {
        Teacher teacher = teacherService.getTeacher(id);
        return ResponseEntity.ok(teacher);
    }

    @GetMapping
    public ResponseEntity<List<Teacher>> getAllTeachers() {
        List<Teacher> teachers = teacherService.getAllTeachers();
        return ResponseEntity.ok(teachers);
    }

    @PostMapping
    public ResponseEntity<Teacher> saveSingleTeacher(@RequestBody Teacher teacher) {
        Teacher savedTeacher = teacherService.saveTeacher(teacher);
        return new ResponseEntity<>(savedTeacher, HttpStatus.CREATED);
    }

    @PostMapping("/bulk")
    public ResponseEntity<List<Teacher>> saveMultipleTeachers(@RequestBody List<Teacher> teachers) {
        List<Teacher> savedTeachers = teacherService.saveAllTeachers(teachers);
        return new ResponseEntity<>(savedTeachers, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSingleTeacher(@PathVariable Long id) {
        teacherService.deleteTeacher(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/bulk")
    public ResponseEntity<Void> deleteMultipleTeachers(@RequestBody List<Long> ids) {
        teacherService.deleteAllTeachers(ids);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}")
    public ResponseEntity<Teacher> updateTeacher(@PathVariable Long id, @RequestBody Teacher teacher) {
        teacher.setId(id);
        Teacher updatedTeacher = teacherService.updateTeacher(teacher);
        return ResponseEntity.ok(updatedTeacher);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Teacher> patchUpdateTeacher(@PathVariable Long id, @RequestBody Teacher partialTeacher) {
        Teacher updatedTeacher = teacherService.patchUpdateTeacher(id, partialTeacher);
        return ResponseEntity.ok(updatedTeacher);
    }
} 