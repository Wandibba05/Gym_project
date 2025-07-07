package com.gymnation.services;

public interface PaymentProcessor{
    boolean process (String userId, double amount);
}