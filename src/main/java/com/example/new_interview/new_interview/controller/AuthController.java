package com.example.new_interview.new_interview.controller;

import com.example.new_interview.new_interview.dto.LoginRequest;
import com.example.new_interview.new_interview.dto.RegisterRequest;
import com.example.new_interview.new_interview.model.User;
import com.example.new_interview.new_interview.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Authentication Controller
 * 
 * Why separate authentication endpoints?
 * - Clear separation of concerns
 * - Better security management
 * - Easier to maintain and extend
 */
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    /**
     * Login Endpoint
     * 
     * Why use ResponseEntity?
     * - Control HTTP status codes
     * - Add custom headers
     * - Better error handling
     */
    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                request.getUsername(),
                request.getPassword()
            )
        );

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String token = jwtService.generateToken(userDetails);

        Map<String, String> response = new HashMap<>();
        response.put("token", token);
        return ResponseEntity.ok(response);
    }

    /**
     * Register Endpoint
     * 
     * Why use @PreAuthorize?
     * - Method-level security
     * - Role-based access control
     * - Flexible authorization rules
     */
    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody RegisterRequest request) {
        // Implementation for user registration
        return ResponseEntity.ok().build();
    }

    /**
     * OAuth2 Login Endpoint
     * 
     * Why use OAuth2 login?
     * - Social login support
     * - Third-party authentication
     * - Delegated authorization
     */
    @GetMapping("/oauth2/login")
    public ResponseEntity<Void> oauth2Login() {
        // OAuth2 login implementation
        return ResponseEntity.ok().build();
    }
}

