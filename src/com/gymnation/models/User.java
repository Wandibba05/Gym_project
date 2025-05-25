package com.gymnation.models;

    public abstract class User {
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

        public void login() {
            System.out.println(name + " logged in.");
        }

        public abstract void displayRole();

        // Getters and Setters
        public String getUserId() { return userId; }
        public String getName() { return name; }
        public String getEmail() { return email; }
        public String getPassword() { return password; }
        public String getGender() { return gender; }

        public void setUserId(String userId) { this.userId = userId; }
        public void setName(String name) { this.name = name; }
        public void setEmail(String email) { this.email = email; }
        public void setPassword(String password) { this.password = password; }
        public void setGender(String gender) { this.gender = gender; }
    }

