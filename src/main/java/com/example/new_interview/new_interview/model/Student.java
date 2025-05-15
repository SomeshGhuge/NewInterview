package com.example.new_interview.new_interview.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/**
 * Student Entity Class
 * 
 * Lombok Annotations Used:
 * @Getter, @Setter: Automatically generates getters and setters
 * @Data: Combines @Getter, @Setter, @ToString, @EqualsAndHashCode, and @RequiredArgsConstructor
 * @AllArgsConstructor: Generates constructor with all fields
 * @NoArgsConstructor: Generates constructor with no parameters
 * @ToString: Generates toString method
 * 
 * Why use Lombok?
 * - Reduces boilerplate code
 * - Improves code readability
 * - Reduces maintenance overhead
 * 
 * Alternative approaches:
 * - Manual getter/setter generation
 * - Using IDE code generation
 * - Using other code generation tools
 */
@Entity
@Table(name="student")
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {

    /**
     * Primary Key Configuration
     * @GeneratedValue strategy options:
     * - IDENTITY: Database auto-increment (current)
     * - AUTO: Let persistence provider choose
     * - SEQUENCE: Use database sequence
     * - TABLE: Use separate table for ID generation
     * - UUID: Generate UUID as primary key
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    /**
     * Basic Entity Attributes
     * @Column: Maps Java fields to database columns
     * Note: List<String> for mobileNumber requires custom type conversion
     */
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

    /**
     * One-to-One Relationship with Money
     * @OneToOne: Defines one-to-one relationship
     * - targetEntity: Specifies the related entity class
     * - cascade = CascadeType.ALL: Propagates all operations
     * 
     * Cascade Types:
     * - ALL: All operations
     * - MERGE: Merge operation only
     * - PERSIST: Persist operation only
     * - DETACH: Detach operation only
     * - REFRESH: Refresh operation only
     * - REMOVE: Remove operation only
     */
    @OneToOne(targetEntity = Money.class, cascade = CascadeType.ALL)
    @Column(name="money")
    private Money money;

    /**
     * One-to-Many Relationship with Medals
     * @OneToMany: Defines one-to-many relationship
     * - mappedBy: Specifies the owning side of the relationship
     * - No cascade specified: Operations don't propagate to medals
     */
    @OneToMany(mappedBy = "student")
    private List<Medals> medals;

    /**
     * Many-to-One Relationship with Teacher
     * @ManyToOne: Defines many-to-one relationship
     * - cascade = CascadeType.ALL: Propagates all operations
     * - No fetch type specified: Uses default (EAGER for @ManyToOne)
     */
    @ManyToOne(cascade = CascadeType.ALL)
    private Teacher teacher;

    /**
     * Many-to-Many Relationship with Course
     * @ManyToMany: Defines many-to-many relationship
     * - cascade = CascadeType.ALL: Propagates all operations
     * - fetch = FetchType.EAGER: Loads related entities immediately
     * 
     * Fetch Types:
     * - EAGER: Load immediately (current)
     * - LAZY: Load on demand
     */
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Course course;
}
