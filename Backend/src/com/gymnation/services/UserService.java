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

        public User(String userId, String name, String email, String password, String gender) {
            this.userId = userId;
            this.name = name;
            this.email = email;
            this.password = password;
            this.gender = gender;
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

        @Override
        public String toString() {
            return "UserID: " + userId + ", Name: " + name + ", Email: " + email + ", Gender: " + gender;
        }
    }

    private Map<String, User> users;

    public UserService() {
        users = new HashMap<>();
    }

    public boolean registerUser(String userId, String name, String email, String password, String gender) {
        if (users.containsKey(userId)) {
            System.out.println("❌ User ID already exists.");
            return false;
        }

        User newUser = new User(userId, name, email, password, gender);
        users.put(userId, newUser);
        System.out.println("✅ Registration successful for: " + name);
        return true;
    }

    public boolean authenticate(String userId, String password) {
        User user = users.get(userId);
        if (user != null && user.getPassword().equals(password)) {
            System.out.println("✅ Login successful. Welcome " + user.getName() + "!");
            return true;
        } else {
            System.out.println("❌ Invalid user ID or password.");
            return false;
        }
    }

    public User getUser(String userId) {
        return users.get(userId);
    }

    public boolean updateUser(String userId, String newName, String newEmail, String newPassword, String newGender) {
        User user = users.get(userId);
        if (user == null) {
            System.out.println("❌ User not found.");
            return false;
        }

        user.setName(newName);
        user.setEmail(newEmail);
        user.setPassword(newPassword);
        user.setGender(newGender);
        System.out.println("✅ User information updated.");
        return true;
    }

    public boolean deleteUser(String userId) {
        if (users.remove(userId) != null) {
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
