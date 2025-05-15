package com.example.new_interview.new_interview.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="money")
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Money {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="currency")
    private String currency;

    @Column(name="amount")
    private int amount;
}
