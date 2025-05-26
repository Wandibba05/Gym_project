package com.gymnation.models;
import com.gymnation.interfaces.Bookable;
import java.time.LocalDateTime;


public class Instructor implements Bookable {
    private String instructorId;
    private String name;
    private String gender;
    private String expertise;
    private boolean available;
    private LocalDateTime availableFrom;
    private LocalDateTime availableTo;

    public Instructor(String instructorId, String name, String gender, String expertise) {
        this.instructorId = instructorId;
        this.name = name;
        this.gender = gender;
        this.expertise = expertise;
        this.available = true;
    }

    @Override
    public boolean isAvailable() {
        return available;
    }

    @Override
    public void updateAvailability(boolean availability) {
        this.available = availability;
    }

    // Getters and Setters
    public String getInstructorId() { return instructorId; }
    public String getName() { return name; }
    public String getGender() { return gender; }
    public String getExpertise() { return expertise; }
    public LocalDateTime getAvailableFrom() { return availableFrom; }
    public LocalDateTime getAvailableTo() { return availableTo; }

    public void setAvailableFrom(LocalDateTime availableFrom) { this.availableFrom = availableFrom; }
    public void setAvailableTo(LocalDateTime availableTo) { this.availableTo = availableTo; }
}


