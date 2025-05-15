package com.example.new_interview.new_interview.controller;

import com.example.new_interview.new_interview.model.*;
import com.example.new_interview.new_interview.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/mapping-demo")
public class MappingDemoController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private MedalsRepository medalsRepository;

    @Autowired
    private MoneyRepository moneyRepository;

    // OneToOne Mapping Demo
    @PostMapping("/one-to-one")
    public ResponseEntity<Map<String, Object>> demonstrateOneToOne() {
        // Create a Money entity
        Money money = new Money();
        money.setCurrency("USD");
        money.setAmount(1000);

        // Create a Student with OneToOne relationship to Money
        Student student = new Student();
        student.setFirstName("John");
        student.setLastName("Doe");
        student.setCity("New York");
        student.setScore(95);
        student.setMoney(money); // OneToOne relationship

        Student savedStudent = studentRepository.save(student);

        return ResponseEntity.ok(Map.of(
            "explanation", "OneToOne: Each student has exactly one money record and vice versa",
            "student", savedStudent
        ));
    }

    // OneToMany Mapping Demo
    @PostMapping("/one-to-many")
    public ResponseEntity<Map<String, Object>> demonstrateOneToMany() {
        // Create a Student
        Student student = new Student();
        student.setFirstName("Jane");
        student.setLastName("Smith");
        student.setCity("Boston");
        student.setScore(98);

        // Create multiple Medals for the student
        Medals goldMedal = new Medals();
        goldMedal.setMedalName("Gold");
        goldMedal.setCompititionName("Math Olympics");
        goldMedal.setCountOfMedal(1);
        goldMedal.setStudent(student);

        Medals silverMedal = new Medals();
        silverMedal.setMedalName("Silver");
        silverMedal.setCompititionName("Science Fair");
        silverMedal.setCountOfMedal(2);
        silverMedal.setStudent(student);

        student.setMedals(Arrays.asList(goldMedal, silverMedal));
        Student savedStudent = studentRepository.save(student);

        return ResponseEntity.ok(Map.of(
            "explanation", "OneToMany: One student can have multiple medals",
            "student", savedStudent
        ));
    }

    // ManyToOne Mapping Demo
    @PostMapping("/many-to-one")
    public ResponseEntity<Map<String, Object>> demonstrateManyToOne() {
        // Create a Teacher
        Teacher teacher = new Teacher();
        teacher.setTeacherName("Prof. Anderson");
        teacher.setSubject("Mathematics");

        // Create multiple students for the teacher
        Student student1 = new Student();
        student1.setFirstName("Alice");
        student1.setLastName("Johnson");
        student1.setCity("Chicago");
        student1.setScore(88);
        student1.setTeacher(teacher);

        Student student2 = new Student();
        student2.setFirstName("Bob");
        student2.setLastName("Wilson");
        student2.setCity("Chicago");
        student2.setScore(92);
        student2.setTeacher(teacher);

        teacher.setStudent(student1); // For demo purposes, setting one student
        Teacher savedTeacher = teacherRepository.save(teacher);

        return ResponseEntity.ok(Map.of(
            "explanation", "ManyToOne: Multiple students can have the same teacher",
            "teacher", savedTeacher
        ));
    }

    // ManyToMany Mapping Demo
    @PostMapping("/many-to-many")
    public ResponseEntity<Map<String, Object>> demonstrateManyToMany() {
        // Create Courses
        Course mathCourse = new Course();
        mathCourse.setCourseName("Advanced Mathematics");
        mathCourse.setTeacherName("Prof. Smith");

        Course physicsCourse = new Course();
        physicsCourse.setCourseName("Physics");
        physicsCourse.setTeacherName("Prof. Brown");

        // Create Students
        Student student1 = new Student();
        student1.setFirstName("Charlie");
        student1.setLastName("Brown");
        student1.setCity("San Francisco");
        student1.setScore(91);

        Student student2 = new Student();
        student2.setFirstName("Diana");
        student2.setLastName("Miller");
        student2.setCity("Los Angeles");
        student2.setScore(94);

        // Set up many-to-many relationships
        mathCourse.setStudents(Arrays.asList(student1, student2));
        physicsCourse.setStudents(Arrays.asList(student1, student2));

        // Save courses (cascade will save students)
        List<Course> savedCourses = courseRepository.saveAll(Arrays.asList(mathCourse, physicsCourse));

        return ResponseEntity.ok(Map.of(
            "explanation", "ManyToMany: Students can enroll in multiple courses, and courses can have multiple students",
            "courses", savedCourses
        ));
    }

    // Get all relationships for a student
    @GetMapping("/relationships/{studentId}")
    public ResponseEntity<Map<String, Object>> getAllRelationships(@PathVariable Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        return ResponseEntity.ok(Map.of(
            "oneToOne_money", student.getMoney(),
            "oneToMany_medals", student.getMedals(),
            "manyToOne_teacher", student.getTeacher(),
            "manyToMany_courses", student.getCourse()
        ));
    }
} 