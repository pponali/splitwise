package com.splitwise.exception.validation;

import com.splitwise.exception.SplitwiseException;

public class DuplicateUsernameException extends SplitwiseException {
    public DuplicateUsernameException(String message) {
        super(message);
    }
}
