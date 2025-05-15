package com.example.new_interview.new_interview.service.serviceImpl;

import com.example.new_interview.new_interview.model.Teacher;
import com.example.new_interview.new_interview.repository.TeacherRepository;
import com.example.new_interview.new_interview.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public Teacher getTeacher(Long id) {
        return teacherRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Teacher not found with id: " + id));
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher saveTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public List<Teacher> saveAllTeachers(List<Teacher> teachers) {
        return teacherRepository.saveAll(teachers);
    }

    @Override
    public void deleteTeacher(Long id) {
        if (!teacherRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Teacher not found with id: " + id);
        }
        teacherRepository.deleteById(id);
    }

    @Override
    public void deleteAllTeachers(List<Long> ids) {
        teacherRepository.deleteAllById(ids);
    }

    @Override
    public Teacher updateTeacher(Teacher teacher) {
        if (!teacherRepository.existsById(teacher.getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Teacher not found with id: " + teacher.getId());
        }
        return teacherRepository.save(teacher);
    }

    @Override
    public Teacher patchUpdateTeacher(Long id, Teacher partialTeacher) {
        Teacher existingTeacher = getTeacher(id);
        
        if (partialTeacher.getTeacherName() != null) {
            existingTeacher.setTeacherName(partialTeacher.getTeacherName());
        }
        if (partialTeacher.getSubject() != null) {
            existingTeacher.setSubject(partialTeacher.getSubject());
        }
        if (partialTeacher.getStudent() != null) {
            existingTeacher.setStudent(partialTeacher.getStudent());
        }

        return teacherRepository.save(existingTeacher);
    }
} 