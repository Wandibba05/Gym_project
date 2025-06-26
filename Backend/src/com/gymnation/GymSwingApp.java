package com.gymnation;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GymSwingApp {

    public static void main(String[] args) {
        // Create the main frame (window)
        JFrame frame = new JFrame("GYMNATION");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create panel to hold components
        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        // Show the frame
        frame.setLocationRelativeTo(null);  // Center window
        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null); // use absolute positioning

        // Username label
        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        // Username text field
        JTextField userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);

        // Password label
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        // Password text field
        JTextField passwordText = new JTextField(20);
        passwordText.setBounds(100, 50, 165, 25);
        panel.add(passwordText);

        // Login button
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(10, 90, 100, 25);
        panel.add(loginButton);

        // Add button click behavior
        loginButton.addActionListener(e -> {
            String username = userText.getText();
            String password = passwordText.getText();
            // Simple login simulation
            if ("admin".equals(username) && "pass".equals(password)) {
                System.out.println("Admin logged in!");
            } else {
                System.out.println("Login failed for user: " + username);
            }
        });
    }
}

