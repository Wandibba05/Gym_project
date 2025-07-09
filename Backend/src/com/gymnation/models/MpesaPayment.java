package com.gymnation.models;

import com.gymnation.interfaces.Payment;

public class MpesaPayment implements Payment {
    private String phoneNumber;
    private String paymentStatus;

    public MpesaPayment(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        this.paymentStatus = "Pending";
    }

    @Override
    public boolean processPayment(double amount) {
        // Simulate M-Pesa payment processing
        System.out.println("Sending M-Pesa payment request of $" + amount + " to " + phoneNumber);
        this.paymentStatus = "Completed";
        return true;
    }

    @Override
    public String getPaymentStatus() {
        return paymentStatus;
    }

    @Override
    public String getPaymentMethod() {
        return "M-Pesa";
    }
}