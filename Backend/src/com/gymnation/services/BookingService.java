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
        // Check if trainer is available
        if (!isTrainerAvailable(trainerName, time)) {
            System.out.println("❌ Sorry, trainer " + trainerName + " is not available at " + time);
            return null;
        }

        // Create booking
        String bookingId = UUID.randomUUID().toString();
        Booking booking = new Booking(bookingId, userId, className, trainerName, time);

        // Add to user bookings
        userBookings.computeIfAbsent(userId, k -> new ArrayList<>()).add(booking);

        // Add to trainer schedule
        trainerSchedule.computeIfAbsent(trainerName, k -> new ArrayList<>()).add(time);

        System.out.println("✅ Booking successful: " + booking);
        return booking;
    }

    public boolean isTrainerAvailable(String trainerName, LocalDateTime time) {
        List<LocalDateTime> bookedTimes = trainerSchedule.getOrDefault(trainerName, new ArrayList<>());
        return !bookedTimes.contains(time);
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

