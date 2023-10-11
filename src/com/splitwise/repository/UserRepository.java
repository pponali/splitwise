package com.splitwise.repository;

import com.splitwise.models.User;

import java.util.Optional;

public interface UserRepository extends IRepository<User, Long> {

    Optional<User> findByUserName(String name);


}
