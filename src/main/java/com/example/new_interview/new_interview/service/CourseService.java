package com.example.new_interview.new_interview.service;

import com.example.new_interview.new_interview.model.Course;
import java.util.List;

public interface CourseService {
    Course getCourse(Long id);
    List<Course> getAllCourses();
    Course saveCourse(Course course);
    List<Course> saveAllCourses(List<Course> courses);
    void deleteCourse(Long id);
    void deleteAllCourses(List<Long> ids);
    Course updateCourse(Course course);
    Course patchUpdateCourse(Long id, Course partialCourse);
} 