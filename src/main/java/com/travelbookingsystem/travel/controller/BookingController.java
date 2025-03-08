package com.travelbookingsystem.travel.controller;

import com.travelbookingsystem.travel.model.Booking;
import com.travelbookingsystem.travel.service.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*") // Allow requests from any origin
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    // Get all bookings
    @GetMapping
    public ResponseEntity<?> getAllBookings() {
        try {
            List<Booking> bookings = bookingService.getAllBookings();
            return ResponseEntity.ok(bookings);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error retrieving bookings: " + e.getMessage());
        }
    }

    // Get booking by ID
    @GetMapping("/{bookingId}")
    public ResponseEntity<?> getBookingById(@PathVariable long bookingId) {
        try {
            Booking booking = bookingService.getBookingById(bookingId);
            return booking != null ? ResponseEntity.ok(booking)
                                   : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Booking not found");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error fetching booking: " + e.getMessage());
        }
    }

    // Get bookings by passenger ID
    @GetMapping("/passenger/{passengerId}")
    public ResponseEntity<?> getBookingsByPassengerId(@PathVariable long passengerId) {
        try {
            List<Booking> bookings = bookingService.getBookingsByPassengerId(passengerId);
            return bookings.isEmpty() ? ResponseEntity.status(HttpStatus.NOT_FOUND).body("No bookings found for this passenger")
                                      : ResponseEntity.ok(bookings);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error retrieving bookings: " + e.getMessage());
        }
    }

    // Get bookings by transport type
    @GetMapping("/transport/{transportType}")
    public ResponseEntity<?> getBookingsByTransportType(@PathVariable String transportType) {
        try {
            List<Booking> bookings = bookingService.getBookingsByTransportType(transportType);
            return bookings.isEmpty() ? ResponseEntity.status(HttpStatus.NOT_FOUND).body("No bookings found for this transport type")
                                      : ResponseEntity.ok(bookings);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error retrieving bookings: " + e.getMessage());
        }
    }

    // Create a train booking
    @PostMapping("/train")
    public ResponseEntity<?> bookTrain(@RequestBody Booking booking) {
        try {
            bookingService.bookTrain(booking);
            return ResponseEntity.status(HttpStatus.CREATED).body("Train booking confirmed");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error booking train: " + e.getMessage());
        }
    }

    // Create a flight booking
    @PostMapping("/flight")
    public ResponseEntity<?> bookFlight(@RequestBody Booking booking) {
        try {
            bookingService.bookFlight(booking);
            return ResponseEntity.status(HttpStatus.CREATED).body("Flight booking confirmed");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error booking flight: " + e.getMessage());
        }
    }

    // Create a bus booking
    @PostMapping("/bus")
    public ResponseEntity<?> bookBus(@RequestBody Booking booking) {
        try {
            bookingService.bookBus(booking);
            return ResponseEntity.status(HttpStatus.CREATED).body("Bus booking confirmed");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error booking bus: " + e.getMessage());
        }
    }

 // Update booking status
    @PutMapping("/{bookingId}/status")
    public ResponseEntity<?> updateBookingStatus(@PathVariable long bookingId, @RequestParam String status) {
        try {
            int updated = bookingService.updateBookingStatus(bookingId, status);
            return updated > 0 ? ResponseEntity.ok("Booking status updated successfully")
                               : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Booking not found");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating booking status: " + e.getMessage());
        }
    }

    // Update payment status
    @PutMapping("/{bookingId}/payment")
    public ResponseEntity<?> updatePaymentStatus(@PathVariable long bookingId, @RequestParam String status) {
        try {
            int updated = bookingService.updatePaymentStatus(bookingId, status);
            return updated>0 ? ResponseEntity.ok("Payment status updated successfully")
                           : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Booking not found");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating payment status: " + e.getMessage());
        }
    }

    // Delete a booking
    @DeleteMapping("/{bookingId}")
    public ResponseEntity<?> deleteBooking(@PathVariable long bookingId) {
        try {
            int deleted = bookingService.deleteBooking(bookingId);
            return deleted>0 ? ResponseEntity.ok("Booking deleted successfully")
                           : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Booking not found");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting booking: " + e.getMessage());
        }
    }
}
