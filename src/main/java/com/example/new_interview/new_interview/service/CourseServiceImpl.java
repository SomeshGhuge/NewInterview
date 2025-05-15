package com.example.new_interview.new_interview.service;

import com.example.new_interview.new_interview.model.Course;
import com.example.new_interview.new_interview.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Course getCourse(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Course not found with id: " + id));
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public List<Course> saveAllCourses(List<Course> courses) {
        return courseRepository.saveAll(courses);
    }

    @Override
    public void deleteCourse(Long id) {
        if (!courseRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Course not found with id: " + id);
        }
        courseRepository.deleteById(id);
    }

    @Override
    public void deleteAllCourses(List<Long> ids) {
        courseRepository.deleteAllById(ids);
    }

    @Override
    public Course updateCourse(Course course) {
        if (!courseRepository.existsById(course.getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Course not found with id: " + course.getId());
        }
        return courseRepository.save(course);
    }

    @Override
    public Course patchUpdateCourse(Long id, Course partialCourse) {
        Course existingCourse = getCourse(id);
        
        if (partialCourse.getCourseName() != null) {
            existingCourse.setCourseName(partialCourse.getCourseName());
        }
        if (partialCourse.getTeacherName() != null) {
            existingCourse.setTeacherName(partialCourse.getTeacherName());
        }
        if (partialCourse.getStudents() != null) {
            existingCourse.setStudents(partialCourse.getStudents());
        }

        return courseRepository.save(existingCourse);
    }
} 