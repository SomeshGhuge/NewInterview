package com.example.new_interview.new_interview.service.serviceImpl;

import com.example.new_interview.new_interview.model.Medals;
import com.example.new_interview.new_interview.repository.MedalsRepository;
import com.example.new_interview.new_interview.service.MedalsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class MedalsServiceImpl implements MedalsService {

    @Autowired
    private MedalsRepository medalsRepository;

    @Override
    public Medals getMedal(Long id) {
        return medalsRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Medal not found with id: " + id));
    }

    @Override
    public List<Medals> getAllMedals() {
        return medalsRepository.findAll();
    }

    @Override
    public Medals saveMedal(Medals medal) {
        return medalsRepository.save(medal);
    }

    @Override
    public List<Medals> saveAllMedals(List<Medals> medals) {
        return medalsRepository.saveAll(medals);
    }

    @Override
    public void deleteMedal(Long id) {
        if (!medalsRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Medal not found with id: " + id);
        }
        medalsRepository.deleteById(id);
    }

    @Override
    public void deleteAllMedals(List<Long> ids) {
        medalsRepository.deleteAllById(ids);
    }

    @Override
    public Medals updateMedal(Medals medal) {
        if (!medalsRepository.existsById(medal.getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Medal not found with id: " + medal.getId());
        }
        return medalsRepository.save(medal);
    }

    @Override
    public Medals patchUpdateMedal(Long id, Medals partialMedal) {
        Medals existingMedal = getMedal(id);
        
        if (partialMedal.getMedalName() != null) {
            existingMedal.setMedalName(partialMedal.getMedalName());
        }
        if (partialMedal.getCompititionName() != null) {
            existingMedal.setCompititionName(partialMedal.getCompititionName());
        }
        if (partialMedal.getCountOfMedal() != 0) {
            existingMedal.setCountOfMedal(partialMedal.getCountOfMedal());
        }
        if (partialMedal.getStudent() != null) {
            existingMedal.setStudent(partialMedal.getStudent());
        }

        return medalsRepository.save(existingMedal);
    }
} 