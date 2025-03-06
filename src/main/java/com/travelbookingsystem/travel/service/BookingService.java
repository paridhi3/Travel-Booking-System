package com.travelbookingsystem.travel.service;

import com.travelbookingsystem.travel.model.Booking;
import com.travelbookingsystem.travel.repository.BookingRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    // Retrieve all bookings
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    // Retrieve a booking by ID
    public Booking getBookingById(long bookingId) {
        return bookingRepository.findById(bookingId);
    }

    // Retrieve bookings by user ID
    public List<Booking> getBookingsByUserId(long userId) {
        return bookingRepository.findByUserId(userId);
    }

    // Retrieve bookings by transport type
    public List<Booking> getBookingsByTransportType(String transportType) {
        return bookingRepository.findByTransportType(transportType);
    }

    // Create a booking
    private void createBooking(Booking booking) {
        booking.setBookingStatus("CONFIRMED");
        booking.setPaymentStatus("PENDING");
        booking.setBookingDate(LocalDateTime.now());
        bookingRepository.save(booking);
    }

    // Book a Train
    public void bookTrain(Booking booking) {
        booking.setTransportType("TRAIN");
        createBooking(booking);
    }

    // Book a Flight
    public void bookFlight(Booking booking) {
        booking.setTransportType("FLIGHT");
        createBooking(booking);
    }

    // Book a Bus
    public void bookBus(Booking booking) {
        booking.setTransportType("BUS");
        createBooking(booking);
    }

    // Update booking status
    public void updateBookingStatus(long bookingId, String status) {
        bookingRepository.updateBookingStatus(bookingId, status);
    }

    // Update payment status
    public void updatePaymentStatus(long bookingId, String status) {
        bookingRepository.updatePaymentStatus(bookingId, status);
    }

    // Delete a booking by ID
    public void deleteBooking(long bookingId) {
        bookingRepository.deleteById(bookingId);
    }
}
