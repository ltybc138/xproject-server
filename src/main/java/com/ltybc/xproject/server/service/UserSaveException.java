package com.ltybc.xproject.server.service;

public class UserSaveException extends RuntimeException {
    public UserSaveException() {
        super("Could not save user.");
    }
}
