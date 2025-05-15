package com.example.new_interview.new_interview.model;

import jakarta.persistence.*;
import lombok.*;

/**
 * Money Entity Class
 * Represents a monetary value with currency and amount
 * 
 * JPA and Lombok Annotations:
 * @Entity: Marks as JPA entity
 * @Table: Maps to 'money' table
 * @Getter/@Setter: Lombok annotations for accessors
 * @Data: Lombok annotation combining multiple features
 * 
 * Why use separate Money entity?
 * - Encapsulates monetary values
 * - Provides type safety
 * - Allows for currency-specific operations
 * - Follows Value Object pattern
 * 
 * Alternative approaches:
 * - Could use BigDecimal for amount
 * - Could use Java Money API (javax.money)
 * - Could use primitive types with currency enum
 */
@Entity
@Table(name="money")
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Money {

    /**
     * Primary Key Configuration
     * Uses IDENTITY strategy for auto-increment
     * Why use Long for ID?
     * - Supports large number of records
     * - Platform independent
     * - Standard practice in JPA
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    /**
     * Currency Field
     * @Column: Maps to 'currency' column
     * Why use String for currency?
     * - Flexible for different currency codes
     * - Easy to validate
     * - Common practice for currency representation
     * 
     * Alternative approaches:
     * - Could use Currency enum
     * - Could use ISO 4217 code constants
     */
    @Column(name="currency")
    private String currency;

    /**
     * Amount Field
     * @Column: Maps to 'amount' column
     * Why use int for amount?
     * - Simple for whole number amounts
     * - Good for fixed-point calculations
     * - Efficient storage
     * 
     * Alternative approaches:
     * - Could use BigDecimal for precise decimals
     * - Could use long for larger amounts
     * - Could use custom Money type
     */
    @Column(name="amount")
    private int amount;
}
