package com.gymnation.services;

import java.util.HashMap;
import java.util.Map;

public class UserService {

    public static class User {
        private String userId;
        private String name;
        private String email;
        private String password;
        private String gender;
        private String role;

        public User(String userId, String name, String email, String password, String gender, String role) {
            this.userId = userId;
            this.name = name;
            this.email = email;
            this.password = password;
            this.gender = gender;
            this.role = role;
        }

        public String getUserId() {
            return userId;
        }

        public String getName() {
            return name;
        }

        public String getEmail() {
            return email;
        }

        public String getPassword() {
            return password;
        }

        public String getGender() {
            return gender;
        }

        public String getRole() {
            return role;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public void setRole(String role) {
            this.role = role;
        }

        @Override
        public String toString() {
            return "UserID: " + userId + ", Name: " + name + ", Email: " + email + ", Gender: " + gender + ", Role: " + role;
        }
    }

    private Map<String, User> users;
    private Map<String, Integer> failedAttempts;

    public UserService() {
        users = new HashMap<>();
        failedAttempts = new HashMap<>();
    }

    public boolean registerUser(String userId, String name, String email, String password, String gender, String role) {
        if (users.containsKey(userId)) {
            System.out.println("❌ User ID already exists.");
            return false;
        }

        if (!email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
            System.out.println("❌ Invalid email format.");
            return false;
        }

        User newUser = new User(userId, name, email, password, gender, role);
        users.put(userId, newUser);
        System.out.println("✅ Registration successful for: " + name);
        return true;
    }

    public boolean authenticate(String userId, String password) {
        if (failedAttempts.getOrDefault(userId, 0) >= 3) {
            System.out.println("❌ Account locked due to too many failed attempts.");
            return false;
        }

        User user = users.get(userId);
        if (user != null && user.getPassword().equals(password)) {
            System.out.println("✅ Login successful. Welcome " + user.getName() + "!");
            failedAttempts.put(userId, 0); // reset on success
            return true;
        } else {
            int attempts = failedAttempts.getOrDefault(userId, 0) + 1;
            failedAttempts.put(userId, attempts);
            System.out.println("❌ Invalid user ID or password. Attempt " + attempts + "/3");
            return false;
        }
    }

    public User getUser(String userId) {
        return users.get(userId);
    }

    public boolean updateUser(String userId, String newName, String newEmail, String newPassword, String newGender, String newRole) {
        User user = users.get(userId);
        if (user == null) {
            System.out.println("❌ User not found.");
            return false;
        }

        if (!newEmail.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
            System.out.println("❌ Invalid email format.");
            return false;
        }

        user.setName(newName);
        user.setEmail(newEmail);
        user.setPassword(newPassword);
        user.setGender(newGender);
        user.setRole(newRole);
        System.out.println("✅ User information updated.");
        return true;
    }

    public boolean deleteUser(String userId) {
        if (users.remove(userId) != null) {
            failedAttempts.remove(userId);
            System.out.println("✅ User deleted.");
            return true;
        } else {
            System.out.println("❌ User not found.");
            return false;
        }
    }

    public void printAllUsers() {
        System.out.println("=== All Registered Users ===");
        for (User user : users.values()) {
            System.out.println(user);
        }
    }
}

