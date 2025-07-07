package com.gymnation.interfaces;

public interface Bookable {
    boolean isAvailable();
    void updateAvailability(boolean availability);
}

