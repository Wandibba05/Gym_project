package com.gymnation;

import com.gymnation.Login;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Optional: use the system look & feel for a native look
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {}

        // Launch the login screen
        SwingUtilities.invokeLater(() -> {
            new Login().setVisible(true);
        });
    }
}
