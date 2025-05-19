package com.gymnation.models;

public class Admin extends User{
    public Admin(String userId, String name, String email, String password, String gender) {
        super(userId, name, email, password, gender);
    }



    @Override
    public void displayRole() {
        System.out.println(getName() + " is an Admin.");
    }

    // Admin-specific methods
    public void manageMembership() {
        System.out.println("Managing memberships...");
        // Add membership management logic here
    }

    public void manageInstructors() {
        System.out.println("Managing instructors...");
        // Add instructor management logic here
    }
}

