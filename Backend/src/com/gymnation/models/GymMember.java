package com.gymnation.models;

public class GymMember extends User {
    private String membershipId;
    private String subscriptionType;
    private Branch branch;

    public GymMember(String userId, String name, String email, String password, String gender, String membershipId, String subscriptionType) {
        super(userId, name, email, password, gender);
        this.membershipId = membershipId;
        this.subscriptionType = subscriptionType;
        this.branch = branch;
    }

    public String getMembershipId() { return membershipId; }
    public String getSubscriptionType() { return subscriptionType; }
    public Branch getBranch() { return branch; }

    @Override
    public void displayRole() {
        System.out.println(getName() + " is a Gym Member with " + subscriptionType + " subscription.");
    }
}
