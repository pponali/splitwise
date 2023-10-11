package com.splitwise.repository;

import com.splitwise.models.Group;

import java.util.List;
import java.util.Optional;

public class InmemoryGroupRepository implements GroupRepository{

    @Override
    public Group create(Group obj) {
        return null;
    }

    @Override
    public Optional<Group> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public List<Group> findAll() {
        return null;
    }

    @Override
    public void save(Group obj) {

    }

    @Override
    public void delete(Long aLong) {

    }
}
