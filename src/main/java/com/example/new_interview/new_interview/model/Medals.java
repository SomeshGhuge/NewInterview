package com.example.new_interview.new_interview.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="medals")
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Medals {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="medalName")
    private String medalName;

    @Column(name="compititionName")
    private String compititionName;

    @Column(name="countOfMedal")
    private int countOfMedal;

    @ManyToOne
    @JoinColumn(name="student_id")
    private Student student;



}
