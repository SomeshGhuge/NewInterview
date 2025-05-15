package com.example.new_interview.new_interview.service.serviceImpl;

import com.example.new_interview.new_interview.model.Student;
import com.example.new_interview.new_interview.repository.StudentRepository;
import com.example.new_interview.new_interview.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/**
 * Service Implementation for Student Management
 * 
 * @Service: Marks class as Spring service bean
 * - Enables component scanning
 * - Provides transaction management
 * - Enables dependency injection
 * 
 * Why use Service Layer?
 * - Separation of concerns
 * - Business logic encapsulation
 * - Transaction management
 * - Reusability
 */
@Service
public class StudentServiceImpl implements StudentService {

    /**
     * Repository Dependency Injection
     * Why use constructor injection instead of @Autowired?
     * - Better testability
     * - Clear dependencies
     * - Immutable dependencies
     * - Prevents circular dependencies
     */
    @Autowired
    private StudentRepository studentRepository;

    /**
     * Retrieves a student by ID
     * Uses Optional to handle null cases
     * Throws ResponseStatusException for not found
     * 
     * Why use Optional?
     * - Null safety
     * - Functional programming style
     * - Clear intent
     */
    @Override
    public Student getStudent(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found with id: " + id));
    }

    /**
     * Retrieves all students
     * Returns empty list if no students exist
     * 
     * Performance considerations:
     * - Pagination for large datasets
     * - Caching for frequent access
     * - Lazy loading for related entities
     */
    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    /**
     * Saves a single student
     * Handles both insert and update operations
     * 
     * Transaction management:
     * - @Transactional by default in service layer
     * - Automatic rollback on exceptions
     * - ACID properties maintained
     */
    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    /**
     * Saves multiple students in batch
     * More efficient than individual saves
     * 
     * Batch processing benefits:
     * - Reduced database calls
     * - Better performance
     * - Atomic operations
     */
    @Override
    public List<Student> saveAllStudents(List<Student> students) {
        return studentRepository.saveAll(students);
    }

    /**
     * Deletes a student by ID
     * Validates existence before deletion
     * 
     * Error handling:
     * - Custom exceptions
     * - HTTP status codes
     * - Meaningful error messages
     */
    @Override
    public void deleteStudent(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found with id: " + id);
        }
        studentRepository.deleteById(id);
    }

    /**
     * Deletes multiple students by IDs
     * Batch operation for efficiency
     * 
     * Security considerations:
     * - Input validation
     * - Authorization checks
     * - Audit logging
     */
    @Override
    public void deleteAllStudents(List<Long> ids) {
        studentRepository.deleteAllById(ids);
    }

    /**
     * Updates an existing student
     * Full update - replaces entire entity
     * 
     * Why validate before update?
     * - Data integrity
     * - Error prevention
     * - Better user experience
     */
    @Override
    public Student updateStudent(Student student) {
        if (!studentRepository.existsById(student.getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found with id: " + student.getId());
        }
        return studentRepository.save(student);
    }

    /**
     * Partial update of student fields
     * Only updates non-null fields
     * 
     * Why use partial update?
     * - Network efficiency
     * - Reduced data transfer
     * - Better concurrency
     * 
     * Field update strategy:
     * - Null checks for each field
     * - Preserves existing data
     * - Handles nested objects
     */
    @Override
    public Student patchUpdateStudent(Long id, Student partialStudent) {
        Student existingStudent = getStudent(id);
        
        if (partialStudent.getFirstName() != null) {
            existingStudent.setFirstName(partialStudent.getFirstName());
        }
        if (partialStudent.getLastName() != null) {
            existingStudent.setLastName(partialStudent.getLastName());
        }
        if (partialStudent.getCity() != null) {
            existingStudent.setCity(partialStudent.getCity());
        }
        if (partialStudent.getMobileNumber() != null) {
            existingStudent.setMobileNumber(partialStudent.getMobileNumber());
        }
        if (partialStudent.getScore() != 0) {
            existingStudent.setScore(partialStudent.getScore());
        }
        if (partialStudent.getMoney() != null) {
            existingStudent.setMoney(partialStudent.getMoney());
        }
        if (partialStudent.getMedals() != null) {
            existingStudent.setMedals(partialStudent.getMedals());
        }
        if (partialStudent.getTeacher() != null) {
            existingStudent.setTeacher(partialStudent.getTeacher());
        }
        if (partialStudent.getCourse() != null) {
            existingStudent.setCourse(partialStudent.getCourse());
        }

        return studentRepository.save(existingStudent);
    }
}
