package com.splitwise.service.authentication;

import com.splitwise.models.User;

import java.util.Optional;

public interface AuthenticationContext {

    public Optional<User> getCurrentlyLoggedinUser();

    User getCurrentlyLoggedInUserOrElseThrow();

    boolean isAuthenticated();

    void setUserId(long userId);



}
