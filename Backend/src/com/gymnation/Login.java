package com.gymnation;

import com.gymnation.models.GymMember;
import java.awt.*;
import javax.swing.*;

public class Login extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;

    public Login() {
        setTitle("Login");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // ✅ Add background image
        JPanel backgroundPanel = new Background("/images/background.png");
        backgroundPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel title = new JLabel("Welcome to Your Gym");
        title.setFont(new Font("SansSerif", Font.BOLD, 18));
        title.setForeground(Color.WHITE);
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 0;
        backgroundPanel.add(title, gbc);

        gbc.gridwidth = 1;

        gbc.gridx = 0;
        gbc.gridy = 1;
        backgroundPanel.add(new JLabel("Username:"), gbc);
        gbc.gridx = 1;
        usernameField = new JTextField(15);
        backgroundPanel.add(usernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        backgroundPanel.add(new JLabel("Password:"), gbc);
        gbc.gridx = 1;
        passwordField = new JPasswordField(15);
        backgroundPanel.add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        JButton loginBtn = new JButton("Login");
        loginBtn.addActionListener(e -> handleLogin());
        backgroundPanel.add(loginBtn, gbc);

        setContentPane(backgroundPanel);
    }

    private void handleLogin() {
        // Your login logic here
        String username = usernameField.getText();

String userId = "U001";
String name = usernameField.getText();
String email = "user@example.com"; // Replace with real value or database query
String password = new String(passwordField.getPassword());
String gender = "Male";
String membershipId = "M123";
String subscriptionType = "Premium";


GymMember member;
        member = new GymMember(userId, name, email, password, gender, membershipId, subscriptionType);

// Example condition — replace with your actual validation logic
if (username.equals("member") && password.equals("1234")) {
    // Close login window
    this.dispose();

    // Open the member dashboard
    SwingUtilities.invokeLater(() -> {
        new MemberDashboard(member).setVisible(true); // or new Booking()...
    });

} else {
    JOptionPane.showMessageDialog(this, "Invalid login. Try again.");
}
    }
}
