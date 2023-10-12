package com.splitwise.exception.authentication;

public class PasswordDoesNotMatchException extends AuthenticationException {
    public PasswordDoesNotMatchException(String message) {
        super(message);
    }
}
