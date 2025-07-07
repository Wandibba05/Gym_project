package com.gymnation.services;

import java.time.LocalDateTime;
import java.util.*;

public class BookingService {

    public static class Booking {
        private String bookingId;
        private String userId;
        private String className;
        private String trainerName;
        private LocalDateTime bookingTime;

        public Booking(String bookingId, String userId, String className, String trainerName, LocalDateTime bookingTime) {
            this.bookingId = bookingId;
            this.userId = userId;
            this.className = className;
            this.trainerName = trainerName;
            this.bookingTime = bookingTime;
        }

        public String getBookingId() {
            return bookingId;
        }

        public String getUserId() {
            return userId;
        }

        public String getClassName() {
            return className;
        }

        public String getTrainerName() {
            return trainerName;
        }

        public LocalDateTime getBookingTime() {
            return bookingTime;
        }

        @Override
        public String toString() {
            return "BookingID: " + bookingId + ", User: " + userId +
                    ", Class: " + className + ", Trainer: " + trainerName +
                    ", Time: " + bookingTime;
        }
    }

    private Map<String, List<Booking>> userBookings;       // userId -> bookings
    private Map<String, List<LocalDateTime>> trainerSchedule; // trainerName -> list of booked times

    public BookingService() {
        userBookings = new HashMap<>();
        trainerSchedule = new HashMap<>();
    }

    public Booking createBooking(String userId, String className, String trainerName, LocalDateTime time) {
        // Check working hours
        if (!isWithinWorkingHours(time)) {
            System.out.println("❌ Bookings are only allowed between 6 AM and 8 PM.");
            return null;
        }

        // Check if user already has a booking at this time
        for (Booking b : userBookings.getOrDefault(userId, new ArrayList<>())) {
            if (b.getBookingTime().equals(time)) {
                System.out.println("❌ You already have a booking at this time.");
                return null;
            }
        }

        // Check trainer availability
        if (!isTrainerAvailable(trainerName, time)) {
            System.out.println("❌ Sorry, trainer " + trainerName + " is not available at " + time);
            return null;
        }

        // Create booking
        String bookingId = UUID.randomUUID().toString();
        Booking booking = new Booking(bookingId, userId, className, trainerName, time);

        // Record user booking
        userBookings.computeIfAbsent(userId, k -> new ArrayList<>()).add(booking);

        // Record trainer booking time
        trainerSchedule.computeIfAbsent(trainerName, k -> new ArrayList<>()).add(time);

        System.out.println("✅ Booking successful: " + booking);
        return booking;
    }

    public boolean isTrainerAvailable(String trainerName, LocalDateTime time) {
        List<LocalDateTime> bookedTimes = trainerSchedule.getOrDefault(trainerName, new ArrayList<>());
        return !bookedTimes.contains(time);
    }

    private boolean isWithinWorkingHours(LocalDateTime time) {
        int hour = time.getHour();
        return hour >= 6 && hour <= 20; // 6 AM to 8 PM
    }

    public List<Booking> getUserBookings(String userId) {
        return userBookings.getOrDefault(userId, Collections.emptyList());
    }

    public boolean cancelBooking(String userId, String bookingId) {
        List<Booking> bookings = userBookings.get(userId);
        if (bookings != null) {
            for (Iterator<Booking> iterator = bookings.iterator(); iterator.hasNext();) {
                Booking b = iterator.next();
                if (b.getBookingId().equals(bookingId)) {
                    iterator.remove();
                    trainerSchedule.get(b.getTrainerName()).remove(b.getBookingTime());
                    System.out.println("✅ Booking canceled successfully.");
                    return true;
                }
            }
        }
        System.out.println("❌ Booking not found or already canceled.");
        return false;
    }

    public void printAllBookings() {
        System.out.println("=== All Bookings ===");
        for (List<Booking> bookings : userBookings.values()) {
            for (Booking b : bookings) {
                System.out.println(b);
            }
        }
    }
}


