package com.splitwise.service.authentication;

public interface PasswordEncoder {
    public String encode(String password, String userName);
}
