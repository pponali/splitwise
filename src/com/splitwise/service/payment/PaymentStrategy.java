package com.splitwise.service.payment;

import com.splitwise.models.Expense;

public interface PaymentStrategy {
    void calculatePaidAmouts(Expense expense);
}
