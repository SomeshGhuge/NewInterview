package com.example.new_interview.new_interview.model;

import jakarta.persistence.*;

@Entity
@Table(name="subjects")
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

}
