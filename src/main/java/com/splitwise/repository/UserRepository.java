package com.splitwise.repository;

import com.splitwise.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//public interface UserRepository extends IRepository<User, Long> {
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUserName(String name);


}
