package com.example.new_interview.new_interview.service;

import com.example.new_interview.new_interview.model.Student;
import com.example.new_interview.new_interview.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student getStudent(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found with id: " + id));
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> saveAllStudents(List<Student> students) {
        return studentRepository.saveAll(students);
    }

    @Override
    public void deleteStudent(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found with id: " + id);
        }
        studentRepository.deleteById(id);
    }

    @Override
    public void deleteAllStudents(List<Long> ids) {
        studentRepository.deleteAllById(ids);
    }

    @Override
    public Student updateStudent(Student student) {
        if (!studentRepository.existsById(student.getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found with id: " + student.getId());
        }
        return studentRepository.save(student);
    }

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
