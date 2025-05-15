package com.example.new_interview.new_interview.constants;


/**
 * Role Enum for User Authorization
 *
 * Why use enum for roles?
 * - Type safety
 * - Prevents invalid role assignments
 * - Easy to maintain and extend
 * - Compile-time checking
 */
public enum Role {
    ROLE_USER,      // Basic user role
    ROLE_ADMIN,     // Administrative role
    ROLE_TEACHER,   // Teacher role
    ROLE_STUDENT    // Student role
}