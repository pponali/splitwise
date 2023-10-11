package com.splitwise.exception.authentication;

public class NotLoggerInUserException extends AuthenticationException {
    public NotLoggerInUserException(String message) {
        super(message);
    }
}
