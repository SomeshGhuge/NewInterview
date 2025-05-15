package com.example.new_interview.new_interview.service.serviceImpl;

import com.example.new_interview.new_interview.model.Money;
import com.example.new_interview.new_interview.repository.MoneyRepository;
import com.example.new_interview.new_interview.service.MoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class MoneyServiceImpl implements MoneyService {

    @Autowired
    private MoneyRepository moneyRepository;

    @Override
    public Money getMoney(Long id) {
        return moneyRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Money not found with id: " + id));
    }

    @Override
    public List<Money> getAllMoney() {
        return moneyRepository.findAll();
    }

    @Override
    public Money saveMoney(Money money) {
        return moneyRepository.save(money);
    }

    @Override
    public List<Money> saveAllMoney(List<Money> moneyList) {
        return moneyRepository.saveAll(moneyList);
    }

    @Override
    public void deleteMoney(Long id) {
        if (!moneyRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Money not found with id: " + id);
        }
        moneyRepository.deleteById(id);
    }

    @Override
    public void deleteAllMoney(List<Long> ids) {
        moneyRepository.deleteAllById(ids);
    }

    @Override
    public Money updateMoney(Money money) {
        if (!moneyRepository.existsById(money.getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Money not found with id: " + money.getId());
        }
        return moneyRepository.save(money);
    }

    @Override
    public Money patchUpdateMoney(Long id, Money partialMoney) {
        Money existingMoney = getMoney(id);
        
        if (partialMoney.getCurrency() != null) {
            existingMoney.setCurrency(partialMoney.getCurrency());
        }
        if (partialMoney.getAmount() != 0) {
            existingMoney.setAmount(partialMoney.getAmount());
        }

        return moneyRepository.save(existingMoney);
    }
} 