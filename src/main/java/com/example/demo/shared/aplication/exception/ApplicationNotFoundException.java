package com.example.demo.shared.aplication.exception;

public class ApplicationNotFoundException extends RuntimeException {
    public ApplicationNotFoundException() {
        super("Element not found");
    }
}
