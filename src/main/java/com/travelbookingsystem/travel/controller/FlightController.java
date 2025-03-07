package com.travelbookingsystem.travel.controller;

import com.travelbookingsystem.travel.model.Flight;
import com.travelbookingsystem.travel.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

    // Retrieve all flights
    @GetMapping
    public List<Flight> getAllFlights() {
        return flightService.getAllFlights();
    }

    // Retrieve flights by source and destination
    @GetMapping("/route")
    public List<Flight> getFlightsByRoute(@RequestParam String source, @RequestParam String destination) {
        return flightService.getFlightsByRoute(source, destination);
    }

    // Add a new flight
    @PostMapping
    public String addFlight(@RequestBody Flight flight) {
        flightService.addFlight(flight);
        return "Flight added successfully!";
    }

    // Update available seats
    @PutMapping("/{flightId}/seats")
    public String updateAvailableSeats(@PathVariable long flightId, @RequestParam int newSeats) {
        flightService.updateAvailableSeats(flightId, newSeats);
        return "Available seats updated successfully!";
    }

    // Delete a flight by ID
    @DeleteMapping("/{flightId}")
    public String deleteFlight(@PathVariable long flightId) {
        flightService.deleteFlight(flightId);
        return "Flight deleted successfully!";
    }
}
