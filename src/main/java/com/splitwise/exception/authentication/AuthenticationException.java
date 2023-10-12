package com.splitwise.exception.authentication;

import com.splitwise.exception.SplitwiseException;

public class AuthenticationException extends SplitwiseException {
    public AuthenticationException(String message) {
        super(message);
    }
}
