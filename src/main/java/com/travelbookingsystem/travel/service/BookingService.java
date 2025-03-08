package com.travelbookingsystem.travel.service;

import com.travelbookingsystem.travel.model.Booking;
import com.travelbookingsystem.travel.repository.BookingRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


/*
 * BookingService Methods:
 * 1. getAllBookings() -> List<Booking>
 * 2. getBookingById(long bookingId) -> Booking
 * 3. getBookingsByPassengerId(long passengerId) -> List<Booking>
 * 4. getBookingsByTransportType(String transportType) -> List<Booking>
 * 5. createBooking(Booking booking) -> void
 * 6. bookTrain(Booking booking) -> void
 * 7. bookFlight(Booking booking) -> void
 * 8. bookBus(Booking booking) -> void
 * 9. updateBookingStatus(long bookingId, String status) -> int
 * 10. updatePaymentStatus(long bookingId, String status) -> int
 * 11. deleteBooking(long bookingId) -> int
 */



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

    // Retrieve bookings by passenger ID
    public List<Booking> getBookingsByPassengerId(long passengerId) {
        return bookingRepository.findByPassengerId(passengerId);
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
    public int updateBookingStatus(long bookingId, String status) {
       return bookingRepository.updateBookingStatus(bookingId, status);
    }

    // Update payment status
    public int updatePaymentStatus(long bookingId, String status) {
        return bookingRepository.updatePaymentStatus(bookingId, status);
    }

    // Delete a booking by ID
    public int deleteBooking(long bookingId) {
        return bookingRepository.deleteById(bookingId);
    }
}
