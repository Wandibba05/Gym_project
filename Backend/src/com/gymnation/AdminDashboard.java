package com.gymnation;


import com.gymnation.models.Admin;

import javax.swing.*;
import java.awt.*;

public class AdminDashboard extends JFrame {
    private Admin admin;

    public AdminDashboard(Admin admin) {
        this.admin = admin;
        setTitle("Admin Dashboard");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initUI();
    }

    private void initUI() {
        JLabel welcome = new JLabel("Welcome Admin: " + admin.getName());
        welcome.setFont(new Font("SansSerif", Font.BOLD, 16));
        add(welcome, BorderLayout.CENTER);
    }
}

