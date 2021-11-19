package com.example.projectreal.Expections;

public class WrongPasswordExpection extends Exception {
    public WrongPasswordExpection(String message) {
        super(message);
    }
}
