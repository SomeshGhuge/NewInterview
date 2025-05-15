package com.example.new_interview.new_interview.controller;

import com.example.new_interview.new_interview.model.Student;
import com.example.new_interview.new_interview.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST Controller for Student Management
 * 
 * @RestController: Combines @Controller and @ResponseBody
 * - @Controller: Marks class as Spring MVC controller
 * - @ResponseBody: Automatically serializes return values to JSON/XML
 * 
 * Why use @RestController?
 * - Simplifies REST API development
 * - Eliminates need for @ResponseBody on each method
 * - Provides automatic content negotiation
 * 
 * @RequestMapping("/api/students"): Base URL for all endpoints
 * - Defines common prefix for all controller methods
 * - Helps in API versioning and organization
 */
@RestController
@RequestMapping("/api/students")
public class StudentController {

    /**
     * Dependency Injection using @Autowired
     * Why use constructor injection instead?
     * - Better testability
     * - Clear dependencies
     * - Immutable dependencies
     * - Prevents circular dependencies
     */
    @Autowired
    private StudentService studentService;

    /**
     * GET endpoint to fetch single student
     * @GetMapping: Maps HTTP GET requests
     * @PathVariable: Extracts value from URL path
     * ResponseEntity: Wraps response with status and headers
     * 
     * Why use ResponseEntity?
     * - Control HTTP status codes
     * - Add custom headers
     * - Better error handling
     */
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id) {
        Student student = studentService.getStudent(id);
        return ResponseEntity.ok(student);
    }

    /**
     * GET endpoint to fetch all students
     * Returns List<Student> wrapped in ResponseEntity
     * 
     * Alternative approaches:
     * - Pagination using Pageable
     * - Sorting using Sort
     * - Filtering using Specification
     */
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }

    /**
     * POST endpoint to create single student
     * @RequestBody: Deserializes JSON to Student object
     * HttpStatus.CREATED: Returns 201 status code
     * 
     * Why use POST for creation?
     * - Idempotent operations
     * - Clear separation of concerns
     * - RESTful principles
     */
    @PostMapping
    public ResponseEntity<Student> saveSingleStudent(@RequestBody Student student) {
        Student savedStudent = studentService.saveStudent(student);
        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }

    /**
     * POST endpoint for bulk student creation
     * Handles multiple students in single request
     * 
     * Performance considerations:
     * - Batch processing
     * - Transaction management
     * - Error handling for partial success
     */
    @PostMapping("/bulk")
    public ResponseEntity<List<Student>> saveMultipleStudents(@RequestBody List<Student> students) {
        List<Student> savedStudents = studentService.saveAllStudents(students);
        return new ResponseEntity<>(savedStudents, HttpStatus.CREATED);
    }

    /**
     * DELETE endpoint for single student
     * Returns 204 No Content on success
     * 
     * Why return 204?
     * - Indicates successful deletion
     * - No content to return
     * - RESTful best practice
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSingleStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * DELETE endpoint for bulk deletion
     * Accepts list of IDs to delete
     * 
     * Security considerations:
     * - Input validation
     * - Authorization checks
     * - Rate limiting
     */
    @DeleteMapping("/bulk")
    public ResponseEntity<Void> deleteMultipleStudents(@RequestBody List<Long> ids) {
        studentService.deleteAllStudents(ids);
        return ResponseEntity.noContent().build();
    }

    /**
     * POST endpoint for full update
     * Replaces entire resource
     * 
     * Why POST instead of PUT?
     * - Maintains backward compatibility
     * - Handles complex updates
     * - Supports partial updates
     */
    @PostMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student) {
        student.setId(id);
        Student updatedStudent = studentService.updateStudent(student);
        return ResponseEntity.ok(updatedStudent);
    }

    /**
     * PATCH endpoint for partial update
     * Updates only specified fields
     * 
     * Why use PATCH?
     * - Efficient for partial updates
     * - Reduces network traffic
     * - Follows HTTP semantics
     */
    @PatchMapping("/{id}")
    public ResponseEntity<Student> patchUpdateStudent(@PathVariable Long id, @RequestBody Student partialStudent) {
        Student updatedStudent = studentService.patchUpdateStudent(id, partialStudent);
        return ResponseEntity.ok(updatedStudent);
    }
}
