package com.travelbookingsystem.travel.controller;

import com.travelbookingsystem.travel.model.Passenger;
import com.travelbookingsystem.travel.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/passengers")
public class PassengerController {

    @Autowired
    private PassengerService passengerService;

    // Retrieve all passengers
    @GetMapping
    public List<Passenger> getAllPassengers() {
        return passengerService.getAllPassengers();
    }

    // Retrieve a passenger by ID
    @GetMapping("/{id}")
    public Passenger getPassenger(@PathVariable Long id) {
        return passengerService.getPassengerById(id);
    }

    // Add a new passenger (Registration)
    @PostMapping
    public String createPassenger(@RequestBody Passenger passenger) {
        passengerService.addPassenger(passenger);
        return "Passenger added successfully";
    }

    // Delete a passenger by ID
    @DeleteMapping("/{id}")
    public String deletePassenger(@PathVariable Long id) {
        passengerService.deletePassenger(id);
        return "Passenger deleted successfully";
    }
}
