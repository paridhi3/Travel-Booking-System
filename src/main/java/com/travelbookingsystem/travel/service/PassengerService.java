package com.travelbookingsystem.travel.service;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.travelbookingsystem.travel.model.Passenger;
import com.travelbookingsystem.travel.repository.PassengerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerService {
    private final PassengerRepository passengerRepository;
//    private final BCryptPasswordEncoder passwordEncoder;

//    public PassengerService(PassengerRepository passengerRepository) {
//        this.passengerRepository = passengerRepository;
//        this.passwordEncoder = new BCryptPasswordEncoder(); // Hashing passwords
//    }
    
    public PassengerService(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

//    public boolean authenticatePassenger(String email, String rawPassword) {
//        Passenger passenger = passengerRepository.findByEmail(email);
//        if (passenger == null) {
//            return false; // Passenger not found
//        }
//        return passwordEncoder.matches(rawPassword, passenger.getPassword()); // Secure validation
//    }

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
    public int deletePassenger(long id) {
        return passengerRepository.deleteById(id);
    }
}
