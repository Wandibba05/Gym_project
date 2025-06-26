package com.gymnation.models;

public class GymMember extends User {
    private String membershipId;
    private String subscriptionType;  // Regular, Premium, Platinum
    private Branch branch;

    public GymMember(String userId, String name, String email, String password, String gender,
                     String membershipId, String subscriptionType, Branch branch) {
        super(userId, name, email, password, gender);
        this.membershipId = membershipId;
        this.subscriptionType = subscriptionType;
        this.branch = branch;
    }

    @Override
    public void displayRole() {
        System.out.println(getName() + " is a Gym Member with " + subscriptionType + " subscription.");
    }

    // Getters and Setters
    public String getMembershipId() { return membershipId; }
    public void setMembershipId(String membershipId) { this.membershipId = membershipId; }

    public String getSubscriptionType() { return subscriptionType; }
    public void setSubscriptionType(String subscriptionType) { this.subscriptionType = subscriptionType; }

    public Branch getBranch() { return branch; }
    public void setBranch(Branch branch) { this.branch = branch; }
}


