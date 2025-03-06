package com.travelbookingsystem.travel.controller;

import com.travelbookingsystem.travel.service.BookingService;
import com.travelbookingsystem.travel.model.Booking;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    // Book Flight
    @PostMapping("/flight")
    public String bookFlight(@RequestBody Booking booking) {
        bookingService.bookFlight(booking);
        return "Flight booked successfully!";
    }

    // Book Train
    @PostMapping("/train")
    public String bookTrain(@RequestBody Booking booking) {
        bookingService.bookTrain(booking);
        return "Train booked successfully!";
    }

    // Book Bus
    @PostMapping("/bus")
    public String bookBus(@RequestBody Booking booking) {
        bookingService.bookBus(booking);
        return "Bus booked successfully!";
    }

    // Get all Bookings by user ID
    @GetMapping("/{id}")
    public List<Booking> getAllBookingByUserId(@PathVariable Long id) {
        return bookingService.getBookingsByUserId(id);
    }
    
    // Get Booking by Booking ID
    @GetMapping("/{id}")
    public Booking getBookingById(@PathVariable Long id) {
        return bookingService.getBookingById(id);
    }
}
