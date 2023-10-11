package com.splitwise.service.authentication;

import com.splitwise.exception.notfound.UserNotFOuntException;
import com.splitwise.models.User;
import com.splitwise.repository.UserRepository;

import java.util.Optional;

public class ConsoleAuthenticationContext implements AuthenticationContext {

    UserRepository userRepository;

    Long userId = -1L;
    public ConsoleAuthenticationContext(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> getCurrentlyLoggedinUser() {
        return userRepository.findById(userId);
    }

    @Override
    public User getCurrentlyLoggedInUserOrElseThrow() {
        return getCurrentlyLoggedinUser().orElseThrow(() -> new UserNotFOuntException("User not found exception!"));
    }

    @Override
    public boolean isAuthenticated() {
        return getCurrentlyLoggedinUser().isPresent();
    }

    @Override
    public void setUserId(long userId) {
        this.userId = userId;
    }
}
