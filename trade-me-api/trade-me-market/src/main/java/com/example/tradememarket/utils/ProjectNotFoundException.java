package com.example.tradememarket.utils;

public class ProjectNotFoundException extends RuntimeException {
    public ProjectNotFoundException() {
        super("User not found.");
    }
}
