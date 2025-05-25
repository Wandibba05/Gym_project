package com.gymnation.models;

public class Branch {
    private String branchId;
    private String name;
    private String location;

    public Branch(String branchId, String name, String location) {
        this.branchId = branchId;
        this.name = name;
        this.location = location;
    }

    // Getters and Setters
    public String getBranchId() { return branchId; }
    public String getName() { return name; }
    public String getLocation() { return location; }

    public void setBranchId(String branchId) { this.branchId = branchId; }
    public void setName(String name) { this.name = name; }
    public void setLocation(String location) { this.location = location; }
}

