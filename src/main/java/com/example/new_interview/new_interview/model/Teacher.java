package com.example.new_interview.new_interview.model;

import jakarta.persistence.*;
import lombok.*;

/**
 * Teacher Entity Class
 * Represents a teacher in the educational system
 * 
 * JPA and Lombok Annotations:
 * @Entity: Marks as JPA entity
 * @Table: Maps to 'teacher' table
 * @Getter/@Setter: Lombok annotations for accessors
 * @Data: Lombok annotation combining multiple features
 * 
 * Why use Lombok annotations?
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
@Table(name="teacher")
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Teacher {
    /**
     * Primary Key Configuration
     * @Id: Marks as primary key
     * @GeneratedValue: Uses IDENTITY strategy for auto-increment
     * @Column: Maps to 'id' column
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    /**
     * Teacher Name Field
     * @Column: Maps to 'teacherName' column
     * Why use String?
     * - Flexible for different name formats
     * - Easy to validate and process
     * - Common practice for name storage
     */
    @Column(name="teacherName")
    private String teacherName;

    /**
     * One-to-One Relationship with Student
     * @OneToOne: Defines one-to-one relationship
     * - mappedBy: Specifies the owning side
     * - No cascade specified: Operations don't propagate
     * 
     * Why One-to-One?
     * - Each teacher has one primary student
     * - Each student has one primary teacher
     * - Maintains referential integrity
     */
    @OneToOne(mappedBy = "teacher")
    private Student student;

    /**
     * Subject Field
     * @Column: Maps to 'subject' column
     * Why use String?
     * - Flexible for different subject names
     * - Easy to update and maintain
     * - Common practice for subject storage
     * 
     * Alternative approaches:
     * - Could use Subject enum
     * - Could use separate Subject entity
     * - Could use subject code system
     */
    @Column(name="subject")
    private String subject;
}
