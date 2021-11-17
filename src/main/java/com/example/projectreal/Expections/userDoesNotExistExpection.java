package com.example.projectreal.Expections;

public class userDoesNotExistExpection extends Exception {
    public userDoesNotExistExpection(String message) {
        super(message);
    }
}
