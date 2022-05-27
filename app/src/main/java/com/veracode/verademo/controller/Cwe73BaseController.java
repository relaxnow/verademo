package com.veracode.verademo.controller;

import com.veracode.verademo.utils.User;

public class Cwe73BaseController {
    public static User getCurrentUser() {
        return User.create("test", "tester", "Test");
    }

    public static boolean userMayAccessFile(User user, String path) {
        return true;
    }

    static class AuthorizationException extends RuntimeException {
        public AuthorizationException(String message, Object variable) {
        }
    }

    static class ValidationException extends RuntimeException {
        public ValidationException(String message, Object o) {

        }
    }
}
