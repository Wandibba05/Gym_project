package com.gymnation.services;

public class DebitCardProcessor implements PaymentProcessor {

    @Override
    public boolean process(String userId, double amount) {
        // Simulate debit card processing logic
        System.out.println("Debit card payment processed for user: " + userId + ", Amount: $" + amount);
        return true;
    }
}
