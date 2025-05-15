package com.example.new_interview.new_interview.dto;

import lombok.*;

/**
 * Register Request DTO
 */
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RegisterRequest {
    private String username;
    private String password;
    private String email;
    // Getters and setters
}