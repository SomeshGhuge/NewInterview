package com.example.new_interview.new_interview.controller;

import com.example.new_interview.new_interview.model.Course;
import com.example.new_interview.new_interview.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourse(@PathVariable Long id) {
        Course course = courseService.getCourse(id);
        return ResponseEntity.ok(course);
    }

    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {
        List<Course> courses = courseService.getAllCourses();
        return ResponseEntity.ok(courses);
    }

    @PostMapping
    public ResponseEntity<Course> saveSingleCourse(@RequestBody Course course) {
        Course savedCourse = courseService.saveCourse(course);
        return new ResponseEntity<>(savedCourse, HttpStatus.CREATED);
    }

    @PostMapping("/bulk")
    public ResponseEntity<List<Course>> saveMultipleCourses(@RequestBody List<Course> courses) {
        List<Course> savedCourses = courseService.saveAllCourses(courses);
        return new ResponseEntity<>(savedCourses, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSingleCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/bulk")
    public ResponseEntity<Void> deleteMultipleCourses(@RequestBody List<Long> ids) {
        courseService.deleteAllCourses(ids);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable Long id, @RequestBody Course course) {
        course.setId(id);
        Course updatedCourse = courseService.updateCourse(course);
        return ResponseEntity.ok(updatedCourse);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Course> patchUpdateCourse(@PathVariable Long id, @RequestBody Course partialCourse) {
        Course updatedCourse = courseService.patchUpdateCourse(id, partialCourse);
        return ResponseEntity.ok(updatedCourse);
    }
} 