package com.example.new_interview.new_interview.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name="teacher")
public class Teacher {
    private Long id;
    private String teacherName;
    private Student student;
    private String subject;
}
