package com.travelbookingsystem.travel.service;

import com.travelbookingsystem.travel.model.Bus;
import com.travelbookingsystem.travel.repository.BusRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusService {
    private final BusRepository busRepository;

    public BusService(BusRepository busRepository) {
        this.busRepository = busRepository;
    }

    // Retrieve all buses
    public List<Bus> getAllBuses() {
        return busRepository.findAll();
    }

    // Retrieve a bus by ID
    public Bus getBusById(long busId) {
        return busRepository.findById(busId);
    }

    // Retrieve buses by source and destination
    public List<Bus> getBusesByRoute(String source, String destination) {
        return busRepository.findBySourceAndDestination(source, destination);
    }

    // Retrieve buses within a price range
    public List<Bus> getBusesByPriceRange(double minPrice, double maxPrice) {
        return busRepository.findByPriceBetween(minPrice, maxPrice);
    }

    // Add a new bus
    public void addBus(Bus bus) {
        busRepository.save(bus);
    }

    // Update bus details
    public void updateBus(Bus bus) {
        busRepository.update(bus);
    }

    // Delete a bus by ID
    public void deleteBus(long busId) {
        busRepository.deleteById(busId);
    }
}
