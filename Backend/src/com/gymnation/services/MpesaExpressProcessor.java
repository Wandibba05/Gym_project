package com.gymnation.services;

public class MpesaExpressProcessor implements PaymentProcessor {

    @Override

    public boolean process(String userId, double amount) {
        // Add real M-Pesa API integration here
        System.out.println("M-Pesa Express payment processed for user: " + userId + ", Amount: $" + amount);
        return true;
    }
}
