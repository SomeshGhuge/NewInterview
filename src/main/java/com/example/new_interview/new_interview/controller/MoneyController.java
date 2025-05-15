package com.example.new_interview.new_interview.controller;

import com.example.new_interview.new_interview.model.Money;
import com.example.new_interview.new_interview.service.MoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/money")
public class MoneyController {

    @Autowired
    private MoneyService moneyService;

    @GetMapping("/{id}")
    public ResponseEntity<Money> getMoney(@PathVariable Long id) {
        Money money = moneyService.getMoney(id);
        return ResponseEntity.ok(money);
    }

    @GetMapping
    public ResponseEntity<List<Money>> getAllMoney() {
        List<Money> moneyList = moneyService.getAllMoney();
        return ResponseEntity.ok(moneyList);
    }

    @PostMapping
    public ResponseEntity<Money> saveSingleMoney(@RequestBody Money money) {
        Money savedMoney = moneyService.saveMoney(money);
        return new ResponseEntity<>(savedMoney, HttpStatus.CREATED);
    }

    @PostMapping("/bulk")
    public ResponseEntity<List<Money>> saveMultipleMoney(@RequestBody List<Money> moneyList) {
        List<Money> savedMoneyList = moneyService.saveAllMoney(moneyList);
        return new ResponseEntity<>(savedMoneyList, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSingleMoney(@PathVariable Long id) {
        moneyService.deleteMoney(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/bulk")
    public ResponseEntity<Void> deleteMultipleMoney(@RequestBody List<Long> ids) {
        moneyService.deleteAllMoney(ids);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}")
    public ResponseEntity<Money> updateMoney(@PathVariable Long id, @RequestBody Money money) {
        money.setId(id);
        Money updatedMoney = moneyService.updateMoney(money);
        return ResponseEntity.ok(updatedMoney);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Money> patchUpdateMoney(@PathVariable Long id, @RequestBody Money partialMoney) {
        Money updatedMoney = moneyService.patchUpdateMoney(id, partialMoney);
        return ResponseEntity.ok(updatedMoney);
    }
} 