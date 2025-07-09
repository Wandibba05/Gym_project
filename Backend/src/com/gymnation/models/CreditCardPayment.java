package com.gymnation.models;

import com.gymnation.interfaces.Payment;

public class CreditCardPayment implements Payment {
    
    private String cardHolder;
    private String paymentStatus;

    public CreditCardPayment(String cardHolder) {
       
        this.cardHolder = cardHolder;
        this.paymentStatus = "Pending";
    }

    @Override
    public boolean processPayment(double amount) {
        // Simulate payment processing (e.g., API call to payment gateway)
        System.out.println("Processing credit card payment of $" + amount + " for " + cardHolder);
        this.paymentStatus = "Completed";
        return true;
    }

    @Override
    public String getPaymentStatus() {
        return paymentStatus;
    }

    @Override
    public String getPaymentMethod() {
        return "Credit Card";
    }
}