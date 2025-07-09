package com.gymnation;

import com.gymnation.models.GymMember;
import com.gymnation.models.Branch;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.*;

public class Login extends JFrame {
    private JTextField emailField;
    private JPasswordField passwordField;

    public Login() {
        setTitle("Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 2));

        add(new JLabel("Email:"));
        emailField = new JTextField();
        add(emailField);

        add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        add(passwordField);

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(this::login);
        add(loginButton);
    }

    private void login(ActionEvent e) {
        String inputEmail = emailField.getText();
        String inputPassword = new String(passwordField.getPassword());

        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM gym_members WHERE email = ? AND password = ?";
            assert conn != null;
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, inputEmail);
            stmt.setString(2, inputPassword);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                GymMember member = new GymMember(
                        rs.getString("user_id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("gender"),
                        rs.getString("membership_id"),
                        rs.getString("subscription_type"),
                        new Branch(rs.getString("branch_id"), rs.getString("branch_location"))
                );

                this.dispose();
                new MemberDashboard(member).setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Login failed. Check your credentials.");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
