package com.swynex.javabasics;

/**
 * Custom exception used when a requested student does not exist.
 */

public class StudentNotFoundException extends Exception {
    public StudentNotFoundException(String message) {
        super(message);
    }
}
