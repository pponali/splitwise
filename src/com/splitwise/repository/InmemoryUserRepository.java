package com.splitwise.repository;

import com.splitwise.models.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class InmemoryUserRepository implements UserRepository {


    Map<Long, User> users = new HashMap<>();
    @Override
    public User create(User user) {
        return users.put(users.size() + 1L, user);
    }

    @Override
    public Optional<User> findById(Long aLong) {
        return Optional.ofNullable(users.get(aLong));
    }

    @Override
    public List<User> findAll() {
        return users.values().stream().toList();
    }

    @Override
    public void save(User obj) {
        users.replace(obj.getId(), obj);
    }

    @Override
    public void delete(Long aLong) {
        users.remove(aLong);

    }

    @Override
    public Optional<User> findByUserName(String name) {
        return users.values().stream()
                .filter((user) -> name.equals(user.getUserName())).findFirst();
    }
}
