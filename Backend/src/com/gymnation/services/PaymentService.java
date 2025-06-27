package com.gymnation.services;

import java.util.HashMap;
import java.util.Map;

public class PaymentService {

    public enum PaymentMethod {
        DEBIT_CARD,
        CREDIT_CARD,
        PAYPAL,
        MPESA_EXPRESS,
        BANK_CARD
    }

    private static final double REQUIRED_PAYMENT = 100.00; // Minimum required payment

    private Map<String, Double> paymentRecords;

    public PaymentService() {
        paymentRecords = new HashMap<>();
    }

    // Process a payment for a user with a specified method
    public boolean processPayment(String userId, double amount, PaymentMethod method) {
        if (amount < REQUIRED_PAYMENT) {
            System.out.println("Sorry, the payment is invalid. Minimum required is $" + REQUIRED_PAYMENT);
            return false;
        }

        System.out.println("Processing payment of $" + amount + " for user: " + userId);
        System.out.println("Payment Method: " + method.name());

        // Simulate payment gateway logic
        switch (method) {
            case DEBIT_CARD:
                System.out.println("Debit card payment processed.");
                break;
            case CREDIT_CARD:
                System.out.println("Credit card payment processed.");
                break;
            case PAYPAL:
                System.out.println("PayPal payment processed.");
                break;
            case MPESA_EXPRESS:
                System.out.println("M-Pesa Express payment processed.");
                break;
            case BANK_CARD:
                System.out.println("Bank card payment processed.");
                break;
            default:
                System.out.println("Sorry, the payment is invalid. Unsupported method.");
                return false;
        }

        // Record the payment
        paymentRecords.put(userId, paymentRecords.getOrDefault(userId, 0.0) + amount);
        System.out.println("Thank you for the payment!");
        return true;
    }

    public double getTotalPaid(String userId) {
        return paymentRecords.getOrDefault(userId, 0.0);
    }

    public boolean hasPaid(String userId) {
        return paymentRecords.containsKey(userId) && paymentRecords.get(userId) >= REQUIRED_PAYMENT;
    }

    public void printAllPayments() {
        System.out.println("=== Payment Records ===");
        for (Map.Entry<String, Double> entry : paymentRecords.entrySet()) {
            System.out.println("User: " + entry.getKey() + " | Total Paid: $" + entry.getValue());
        }
    }
}


