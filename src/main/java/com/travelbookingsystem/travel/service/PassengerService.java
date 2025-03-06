package com.travelbookingsystem.travel.service;

import com.travelbookingsystem.travel.model.Passenger;
import com.travelbookingsystem.travel.repository.PassengerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerService {
    private final PassengerRepository passengerRepository;

    public PassengerService(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    // Retrieve all passengers
    public List<Passenger> getAllPassengers() {
        return passengerRepository.findAll();
    }

    // Retrieve a passenger by ID
    public Passenger getPassengerById(long id) {
        return passengerRepository.findById(id);
    }

    // Add a new passenger
    public void addPassenger(Passenger passenger) {
        passengerRepository.save(passenger);
    }

    // Delete a passenger by ID
    public void deletePassenger(long id) {
        passengerRepository.deleteById(id);
    }
}
