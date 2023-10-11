package com.splitwise.service.split;

import com.splitwise.models.Expense;


public interface SplitStrategy {
    void calculateOwedAmounts(Expense expense);
}
