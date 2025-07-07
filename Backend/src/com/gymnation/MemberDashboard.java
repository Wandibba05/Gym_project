package com.gymnation;

import com.gymnation.models.GymMember;

import javax.swing.*;
import java.awt.*;

public class MemberDashboard extends JFrame {
    private GymMember member;

    public MemberDashboard(GymMember member) {
        this.member = member;
        setTitle("Member Dashboard");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initUI();
    }

    private void initUI() {
        JLabel welcome = new JLabel("Welcome " + member.getName() + " - Package: " + member.getSubscriptionType());
        welcome.setFont(new Font("SansSerif", Font.BOLD, 16));
        add(welcome, BorderLayout.CENTER);
    }
}

