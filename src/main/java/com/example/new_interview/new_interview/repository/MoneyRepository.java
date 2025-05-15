package com.example.new_interview.new_interview.repository;

import com.example.new_interview.new_interview.model.Money;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoneyRepository extends JpaRepository<Money, Long> {
} 