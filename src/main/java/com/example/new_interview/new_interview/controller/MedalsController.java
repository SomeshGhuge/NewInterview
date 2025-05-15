package com.example.new_interview.new_interview.controller;

import com.example.new_interview.new_interview.model.Medals;
import com.example.new_interview.new_interview.service.MedalsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medals")
public class MedalsController {

    @Autowired
    private MedalsService medalsService;

    @GetMapping("/{id}")
    public ResponseEntity<Medals> getMedal(@PathVariable Long id) {
        Medals medal = medalsService.getMedal(id);
        return ResponseEntity.ok(medal);
    }

    @GetMapping
    public ResponseEntity<List<Medals>> getAllMedals() {
        List<Medals> medals = medalsService.getAllMedals();
        return ResponseEntity.ok(medals);
    }

    @PostMapping
    public ResponseEntity<Medals> saveSingleMedal(@RequestBody Medals medal) {
        Medals savedMedal = medalsService.saveMedal(medal);
        return new ResponseEntity<>(savedMedal, HttpStatus.CREATED);
    }

    @PostMapping("/bulk")
    public ResponseEntity<List<Medals>> saveMultipleMedals(@RequestBody List<Medals> medals) {
        List<Medals> savedMedals = medalsService.saveAllMedals(medals);
        return new ResponseEntity<>(savedMedals, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSingleMedal(@PathVariable Long id) {
        medalsService.deleteMedal(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/bulk")
    public ResponseEntity<Void> deleteMultipleMedals(@RequestBody List<Long> ids) {
        medalsService.deleteAllMedals(ids);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}")
    public ResponseEntity<Medals> updateMedal(@PathVariable Long id, @RequestBody Medals medal) {
        medal.setId(id);
        Medals updatedMedal = medalsService.updateMedal(medal);
        return ResponseEntity.ok(updatedMedal);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Medals> patchUpdateMedal(@PathVariable Long id, @RequestBody Medals partialMedal) {
        Medals updatedMedal = medalsService.patchUpdateMedal(id, partialMedal);
        return ResponseEntity.ok(updatedMedal);
    }
} 