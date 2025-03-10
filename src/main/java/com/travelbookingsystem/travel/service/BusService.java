package com.travelbookingsystem.travel.service;

import com.travelbookingsystem.travel.model.Bus;
import com.travelbookingsystem.travel.repository.BusRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * BusService Methods:
 * 1. saveBus(Bus bus) -> int
 * 2. getAllBuses() -> List<Bus>
 * 3. getBusById(long busId) -> Bus
 * 4. updateBus(Bus bus) -> int
 * 5. reduceAvailableSeats(Long busId) -> boolean
 * 6. deleteBusById(long busId) -> int
 * 7. getBusesBySourceAndDestination(String source, String destination) -> List<Bus>
 * 8. getBusesByPriceRange(double minPrice, double maxPrice) -> List<Bus>
 */

@Service
public class BusService {

	@Autowired
    private final BusRepository busRepository;

    public BusService(BusRepository busRepository) {
        this.busRepository = busRepository;
    }

    // Save a new bus
    public int saveBus(Bus bus) {
        return busRepository.save(bus);
    }

    // Retrieve all buses
    public List<Bus> getAllBuses() {
        return busRepository.findAll();
    }

    // Find a bus by its ID
    public Bus getBusById(long busId) {
        return busRepository.findById(busId);
    }

    // Update bus details
    public int updateBus(Bus bus) {
        return busRepository.update(bus);
    }
    
    // Update available seats when a booking is made   
    @Transactional
    public boolean reduceAvailableSeats(Long busId) {
        Bus bus = busRepository.findById(busId);
        
        if (bus == null) {
            System.out.println("Bus not found with ID: " + busId);
            return false;
        }

        if (bus.getAvailableSeats() <= 0) {
            System.out.println("No available seats for Bus ID: " + busId);
            return false;
        }
        
        System.out.println("Before Update: Available Seats = " + bus.getAvailableSeats());

        int rowsUpdated = busRepository.updateAvailableSeats(busId, 1);
        bus.setAvailableSeats(bus.getAvailableSeats() - 1);
        
        System.out.println("After Update: Available Seats = " + bus.getAvailableSeats());
        
        return rowsUpdated > 0;
    }

    // Delete a bus by ID
    public int deleteBusById(long busId) {
        return busRepository.deleteById(busId);
    }

    // Retrieve buses by source and destination
    public List<Bus> getBusesBySourceAndDestination(String source, String destination) {
        return busRepository.findBySourceAndDestination(source, destination);
    }

    // Retrieve buses within a price range
    public List<Bus> getBusesByPriceRange(double minPrice, double maxPrice) {
        return busRepository.findByPriceBetween(minPrice, maxPrice);
    }
}
