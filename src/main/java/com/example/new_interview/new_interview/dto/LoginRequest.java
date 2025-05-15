package com.example.new_interview.new_interview.dto;

import lombok.*;

/**
 * Login Request DTO
 */
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LoginRequest {
    private String username;
    private String password;
    // Getters and setters
}

