package com.splitwise.exception.validation;

import com.splitwise.exception.SplitwiseException;

/**
 * @author prakashponali
 * @Date 12/10/23
 */
public class InvvalidUserNameException extends SplitwiseException {
    public InvvalidUserNameException(final String s) {
        super(s);
    }
}
