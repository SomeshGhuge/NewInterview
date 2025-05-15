package com.example.new_interview.new_interview.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO,IDENTITY,INCREMENT,UUID,SEQUENCE,TABLE
    @Column(name="id")
    private Long id;

    @Column(name="firstName")
    private String firstName;
    @Column(name="lastName")
    private String lastName;
    @Column(name="city")
    private String city;
    @Column(name="mobileNumber")
    private List<String> mobileNumber;
    @Column(name="score")
    private int score;

    @OneToOne(targetEntity = Money.class,cascade = CascadeType.ALL)//All,MERGE,PERSIST,DETACH,REFRESH,REMOVE
    @Column(name="money")
    private Money money;

    @OneToMany(mappedBy = "student")
    private List<Medals> medals;

    @ManyToOne(cascade = CascadeType.ALL)
    private Teacher teacher;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)//EAGER,LAZY
    private Course course;

}
