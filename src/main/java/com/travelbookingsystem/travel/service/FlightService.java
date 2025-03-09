package com.travelbookingsystem.travel.service;

import com.travelbookingsystem.travel.model.Flight;
import com.travelbookingsystem.travel.repository.FlightRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * FlightService Methods:
 * 1. saveFlight(Flight flight) -> int
 * 2. getAllFlightes() -> List<Flight>
 * 3. getFlightById(long flightId) -> Flight
 * 4. updateFlight(Flight flight) -> int
 * 5. reduceAvailableSeats(Long flightId) -> boolean
 * 6. deleteFlightById(long flightId) -> int
 * 7. getFlightesBySourceAndDestination(String source, String destination) -> List<Flight>
 * 8. getFlightesByPriceRange(double minPrice, double maxPrice) -> List<Flight>
 */


@Service
public class FlightService {
    private final FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    // Save a new flight
    public int saveFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    // Retrieve all flights
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    // Retrieve a flight by ID
    public Flight getFlightById(long flightId) {
        return flightRepository.findById(flightId);
    }

    // Update flight details
    public int updateFlight(Flight flight) {
        return flightRepository.update(flight);
    }
    
    // Update available seats when a booking is made   
    @Transactional
    public boolean reduceAvailableSeats(Long flightId) {
        Flight flight = flightRepository.findById(flightId);
        
        if (flight == null) {
            System.out.println("Flight not found with ID: " + flightId);
            return false;
        }

        if (flight.getAvailableSeats() <= 0) {
            System.out.println("No available seats for Flight ID: " + flightId);
            return false;
        }
        
        System.out.println("Before Update: Available Seats = " + flight.getAvailableSeats());

        int rowsUpdated = flightRepository.updateAvailableSeats(flightId, 1);
        flight.setAvailableSeats(flight.getAvailableSeats() - 1);
        
        System.out.println("After Update: Available Seats = " + flight.getAvailableSeats());
        
        return rowsUpdated > 0;
    }

    // Delete a flight by ID
    public int deleteFlightById(long flightId) {
        return flightRepository.deleteById(flightId);
    }

    // Retrieve flights by source and destination
    public List<Flight> getFlightsBySourceAndDestination(String source, String destination) {
        return flightRepository.findBySourceAndDestination(source, destination);
    }

    // Retrieve flights within a specific price range
    public List<Flight> getFlightsByPriceRange(double minPrice, double maxPrice) {
        return flightRepository.findByPriceBetween(minPrice, maxPrice);
    }
}
