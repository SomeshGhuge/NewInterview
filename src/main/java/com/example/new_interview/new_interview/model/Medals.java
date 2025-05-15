package com.example.new_interview.new_interview.model;

import jakarta.persistence.*;
import lombok.*;

/**
 * Medals Entity Class
 * Represents medals/awards earned by students
 * 
 * JPA and Lombok Annotations:
 * @Entity: Marks as JPA entity
 * @Table: Maps to 'medals' table
 * @Getter/@Setter: Lombok annotations for accessors
 * @Data: Lombok annotation combining multiple features
 * 
 * Why use separate Medals entity?
 * - Tracks student achievements
 * - Supports multiple medals per student
 * - Maintains historical record
 * - Follows normalization principles
 * 
 * Alternative approaches:
 * - Could use enum for medal types
 * - Could use separate competition entity
 * - Could use JSON/array field in Student
 */
@Entity
@Table(name="medals")
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Medals {

    /**
     * Primary Key Configuration
     * @Id: Marks as primary key
     * @GeneratedValue: Uses IDENTITY strategy for auto-increment
     * @Column: Maps to 'id' column
     */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    /**
     * Medal Name Field
     * @Column: Maps to 'medalName' column
     * Why use String?
     * - Flexible for different medal types
     * - Easy to update and maintain
     * - Common practice for award names
     * 
     * Alternative approaches:
     * - Could use MedalType enum
     * - Could use medal code system
     */
    @Column(name="medalName")
    private String medalName;

    /**
     * Competition Name Field
     * @Column: Maps to 'competitionName' column
     * Why use String?
     * - Flexible for different competition names
     * - Easy to update and maintain
     * - Common practice for event names
     * 
     * Alternative approaches:
     * - Could use Competition entity
     * - Could use competition code system
     */
    @Column(name="competitionName")
    private String competitionName;

    /**
     * Medal Count Field
     * @Column: Maps to 'countOfMedal' column
     * Why use int?
     * - Simple for whole number counts
     * - Efficient storage
     * - Good for basic counting
     * 
     * Alternative approaches:
     * - Could use short for smaller ranges
     * - Could use long for larger counts
     */
    @Column(name="countOfMedal")
    private int countOfMedal;

    /**
     * Many-to-One Relationship with Student
     * @ManyToOne: Defines many-to-one relationship
     * @JoinColumn: Specifies the foreign key column
     * 
     * Why Many-to-One?
     * - Each medal belongs to one student
     * - A student can have multiple medals
     * - Maintains referential integrity
     * 
     * Why use @JoinColumn?
     * - Explicitly defines the foreign key
     * - Provides better control over the relationship
     * - Makes the database schema clearer
     */
    @ManyToOne
    @JoinColumn(name="student_id")
    private Student student;
}
