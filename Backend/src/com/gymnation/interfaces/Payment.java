package com.gymnation.interfaces;

public interface Payment {
    boolean processPayment(double amount);
    String getPaymentStatus();
    String getPaymentMethod();
}