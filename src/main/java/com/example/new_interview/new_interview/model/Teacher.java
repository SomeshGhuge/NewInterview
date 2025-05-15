package com.example.new_interview.new_interview.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name="teacher")
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Teacher {
    private Long id;
    private String teacherName;
    private Student student;
    private String subject;
}
