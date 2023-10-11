package com.splitwise.exception.validation;

import com.splitwise.exception.SplitwiseException;

public class InvalidUserNameException extends SplitwiseException {
    public InvalidUserNameException(String message) {
        super(message);
    }
}
