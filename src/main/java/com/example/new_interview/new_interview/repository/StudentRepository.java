package com.example.new_interview.new_interview.repository;

import com.example.new_interview.new_interview.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository Interface for Student Entity
 * 
 * @Repository: Marks interface as Spring Data repository
 * - Enables component scanning
 * - Provides exception translation
 * - Enables transaction management
 * 
 * Why use @Repository?
 * - Data access abstraction
 * - Exception translation
 * - Transaction management
 * - Component scanning
 * 
 * JpaRepository Features:
 * - Basic CRUD operations
 * - Pagination support
 * - Sorting support
 * - Query methods
 * - Batch operations
 * 
 * Generic Parameters:
 * - Student: Entity type
 * - Long: ID type
 * 
 * Available Methods (inherited from JpaRepository):
 * - save(): Save entity
 * - findById(): Find by primary key
 * - findAll(): Get all entities
 * - delete(): Remove entity
 * - count(): Get total count
 * 
 * Why use Spring Data JPA?
 * - Reduces boilerplate code
 * - Automatic query generation
 * - Type-safe queries
 * - Easy testing
 * - Transaction management
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
