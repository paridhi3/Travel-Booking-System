package com.travelbookingsystem.travel.service;

import com.travelbookingsystem.travel.model.Booking;
import com.travelbookingsystem.travel.repository.BookingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	
	@Autowired
    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }
    
    @Autowired
    private FlightService flightService;
    @Autowired
    private TrainService trainService;
    @Autowired
    private BusService busService;

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
    @Transactional    
    public int createBooking(Booking booking, Long passengerId, Long transportId) {
    	
    	booking.setPassengerId(passengerId);
    	booking.setTransportId(transportId);
    	booking.setBookingDate(LocalDateTime.now());
    	boolean seatsUpdated;
    	
    	System.out.println(booking.getTransportType());
    	
        switch (booking.getTransportType().toUpperCase()) {
            case "FLIGHT":
            	System.out.println("Reducing seats for FLIGHT ID: " + booking.getTransportId());
            	seatsUpdated = flightService.reduceAvailableSeats(booking.getTransportId());
                break;
            case "TRAIN":
            	System.out.println("Reducing seats for TRAIN ID: " + booking.getTransportId());
            	seatsUpdated = trainService.reduceAvailableSeats(booking.getTransportId());
            	break;
            case "BUS":
            	System.out.println("Reducing seats for BUS ID: " + booking.getTransportId());
            	seatsUpdated = busService.reduceAvailableSeats(booking.getTransportId());
            	break;
            default:
            	System.out.println("Invalid transport type: " + booking.getTransportType());
                return 0;
        }
        
        System.out.println("Booking confirmed");
        
        if (!seatsUpdated) {
            throw new IllegalStateException("No available seats for this booking");
        }

        return bookingRepository.save(booking);
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
