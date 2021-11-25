package com.example.projectreal.Expections;

public class UserDoesNotExistExpection extends Exception {
    public UserDoesNotExistExpection(String message) {
        super(message);
    }
}