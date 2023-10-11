package com.splitwise.repository;

import com.splitwise.models.Expense;

import java.util.List;
import java.util.Optional;

public class InmemoryExpenseRepository implements ExpenseRepository {
    @Override
    public Expense create(Expense obj) {
        return null;
    }

    @Override
    public Optional<Expense> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public List<Expense> findAll() {
        return null;
    }

    @Override
    public void save(Expense obj) {

    }

    @Override
    public void delete(Long aLong) {

    }
}
