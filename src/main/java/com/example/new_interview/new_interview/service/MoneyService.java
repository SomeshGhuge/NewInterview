package com.example.new_interview.new_interview.service;

import com.example.new_interview.new_interview.model.Money;
import java.util.List;

public interface MoneyService {
    Money getMoney(Long id);
    List<Money> getAllMoney();
    Money saveMoney(Money money);
    List<Money> saveAllMoney(List<Money> moneyList);
    void deleteMoney(Long id);
    void deleteAllMoney(List<Long> ids);
    Money updateMoney(Money money);
    Money patchUpdateMoney(Long id, Money partialMoney);
} 