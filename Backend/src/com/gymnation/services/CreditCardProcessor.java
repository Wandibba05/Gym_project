package com.gymnation.services;

public class CreditCardProcessor implements PaymentProcessor {
    @Override

    public boolean process(String userId, double amount) {
        System.out.println("Processing Credit Card payment for user: " + userId + ", Amount: $" + amount);
        return true;
    }
}
