package com.example.new_interview.new_interview.service;

import com.example.new_interview.new_interview.model.Medals;
import java.util.List;

public interface MedalsService {
    Medals getMedal(Long id);
    List<Medals> getAllMedals();
    Medals saveMedal(Medals medal);
    List<Medals> saveAllMedals(List<Medals> medals);
    void deleteMedal(Long id);
    void deleteAllMedals(List<Long> ids);
    Medals updateMedal(Medals medal);
    Medals patchUpdateMedal(Long id, Medals partialMedal);
} 