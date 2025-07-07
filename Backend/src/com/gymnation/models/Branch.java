package com.gymnation.models;

public class Branch {
    private String branchId;
    private String location;

    public Branch(String branchId, String location) {
        this.branchId = branchId;
        this.location = location;
    }

    public String getBranchId() {
        return branchId;
    }

    public String getLocation() {
        return location;
    }
}
