package com.gymnation.services;

public class PaypalProcessor implements PaymentProcessor {
    @Override
    public boolean process(String userId, double amount) {
        System.out.println("Processing Debit Card payment for user: " + userId + ", Amount: $" + amount);
        return true;
    }
}
