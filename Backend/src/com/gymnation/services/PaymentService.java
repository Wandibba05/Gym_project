package com.gymnation.services;

import java.util.HashMap;
import java.util.Map;

public class PaymentService {

    private static final double REQUIRED_PAYMENT = 100.00;

    public enum PaymentMethod {
        DEBIT_CARD,
        CREDIT_CARD,
        PAYPAL,
        MPESA_EXPRESS,

    }

    private Map<String, Double> paymentRecords = new HashMap<>();
    private Map<PaymentMethod, PaymentProcessor> processors = new HashMap<>();

    public PaymentService() {
        // Register processors (strategy map)
        processors.put(PaymentMethod.DEBIT_CARD, new DebitCardProcessor());
        processors.put(PaymentMethod.CREDIT_CARD, new CreditCardProcessor());
        processors.put(PaymentMethod.PAYPAL, new PaypalProcessor());
        processors.put(PaymentMethod.MPESA_EXPRESS, new MpesaExpressProcessor());

    }

    public boolean processPayment(String userId, double amount, PaymentMethod method) {
        if (amount < REQUIRED_PAYMENT) {
            System.out.println("Sorry, the payment is invalid. Minimum required is $" + REQUIRED_PAYMENT);
            return false;
        }

        PaymentProcessor processor = processors.get(method);

        if (processor == null) {
            System.out.println("Unsupported payment method: " + method);
            return false;
        }

        boolean success = processor.process(userId, amount);
        if (success) {
            paymentRecords.put(userId, paymentRecords.getOrDefault(userId, 0.0) + amount);
            System.out.println("Thank you for the payment!");
        }
        return success;
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
