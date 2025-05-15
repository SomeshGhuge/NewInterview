package com.example.new_interview.new_interview.model;

import jakarta.persistence.*;

//Data
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
@Entity
@Table(name="course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="courseName")
    private String courseName;
    @Column(name="teacherName")
    private String teacherName;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Student student;

    public Course() {
    }

    public Course(Long id, String courseName, String teacherName, Student student) {
        this.id = id;
        this.courseName = courseName;
        this.teacherName = teacherName;
        this.student = student;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", student=" + student +
                '}';
    }
}
