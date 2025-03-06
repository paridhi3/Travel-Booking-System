package com.travelbookingsystem.travel.service;

import com.travelbookingsystem.travel.model.Flight;
import com.travelbookingsystem.travel.repository.FlightRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {
    private final FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    // Retrieve all flights
    public List<Flight> getAllFlights() {
        return flightRepository.getAllFlights();
    }

    // Retrieve flights by source and destination
    public List<Flight> getFlightsByRoute(String source, String destination) {
        return flightRepository.findFlightsByRoute(source, destination);
    }

    // Add a new flight
    public void addFlight(Flight flight) {
        flightRepository.save(flight);
    }

    // Update available seats
    public void updateAvailableSeats(long flightId, int newSeats) {
        flightRepository.updateAvailableSeats(flightId, newSeats);
    }

    // Delete a flight by ID
    public void deleteFlight(long flightId) {
        flightRepository.deleteFlight(flightId);
    }
}
