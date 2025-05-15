package com.example.new_interview.new_interview.model;

import jakarta.persistence.*;
import java.util.List;

/**
 * Course Entity Class
 * 
 * JPA Annotations Used:
 * @Entity: Marks this class as a JPA entity that can be persisted to the database
 * @Table: Specifies the database table name (default would be class name in lowercase)
 * 
 * Why use JPA annotations?
 * - Enables Object-Relational Mapping (ORM)
 * - Reduces boilerplate SQL code
 * - Provides database independence
 * 
 * Alternative approaches:
 * - Could use raw JDBC (more control but more code)
 * - Could use Spring JDBC Template
 * - Could use MyBatis for SQL mapping
 */
@Entity
@Table(name="course")
public class Course {

    /**
     * Primary Key Configuration
     * @Id: Marks this field as the primary key
     * @GeneratedValue: Configures how the primary key is generated
     * - strategy = GenerationType.IDENTITY: Uses database auto-increment
     * 
     * Why use IDENTITY strategy?
     * - Simple and widely supported
     * - Good for single-database applications
     * - Automatic value generation
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    /**
     * Basic column mappings
     * @Column: Maps Java field to database column
     * - name: Specifies the column name in the database
     */
    @Column(name="courseName")
    private String courseName;
    
    @Column(name="teacherName")
    private String teacherName;

    /**
     * Many-to-Many Relationship Configuration
     * @ManyToMany: Defines a many-to-many relationship with Student entity
     * - cascade = CascadeType.ALL: Propagates all operations to related entities
     * - fetch = FetchType.EAGER: Loads related entities immediately
     * 
     * @JoinTable: Configures the join table for the many-to-many relationship
     * - name: Specifies the join table name
     * - joinColumns: Defines the foreign key for this entity
     * - inverseJoinColumns: Defines the foreign key for the related entity
     * 
     * Why use EAGER fetching?
     * - Immediate loading of related data
     * - Reduces N+1 query problem
     * - Better for small, frequently accessed relationships
     * 
     * Alternative approaches:
     * - LAZY fetching (load on demand)
     * - Custom query with JOIN FETCH
     * - Separate service layer for relationship management
     */
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
        name = "course_student",
        joinColumns = @JoinColumn(name = "course_id"),
        inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<Student> students;

    public Course() {
    }

    public Course(Long id, String courseName, String teacherName, List<Student> students) {
        this.id = id;
        this.courseName = courseName;
        this.teacherName = teacherName;
        this.students = students;
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

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", students=" + students +
                '}';
    }
}
