package com.splitwise.repository;

import com.splitwise.models.User;

import java.util.List;
import java.util.Optional;

public interface IRepository<E, Id> {
    //Create
    E create(E obj);

    //Read
    Optional<E> findById(Id id);

    List<E> findAll();

    //Update
    void save(E obj);

    //Delete
    void delete(Id id);
}
