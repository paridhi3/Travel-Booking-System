package com.travelbookingsystem.travel.controller;

import com.travelbookingsystem.travel.model.Bus;
import com.travelbookingsystem.travel.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/buses")
public class BusController {

    @Autowired
    private BusService busService;

    // Retrieve all buses
    @GetMapping
    public List<Bus> getAllBuses() {
        return busService.getAllBuses();
    }

    // Retrieve a bus by ID
    @GetMapping("/{busId}")
    public Bus getBusById(@PathVariable long busId) {
        return busService.getBusById(busId);
    }

    // Retrieve buses by source and destination
    @GetMapping("/route")
    public List<Bus> getBusesByRoute(@RequestParam String source, @RequestParam String destination) {
        return busService.getBusesByRoute(source, destination);
    }

    // Retrieve buses within a price range
    @GetMapping("/price-range")
    public List<Bus> getBusesByPriceRange(@RequestParam double minPrice, @RequestParam double maxPrice) {
        return busService.getBusesByPriceRange(minPrice, maxPrice);
    }

    // Add a new bus
    @PostMapping
    public String addBus(@RequestBody Bus bus) {
        busService.addBus(bus);
        return "Bus added successfully!";
    }

    // Update bus details
    @PutMapping
    public String updateBus(@RequestBody Bus bus) {
        busService.updateBus(bus);
        return "Bus updated successfully!";
    }

    // Delete a bus by ID
    @DeleteMapping("/{busId}")
    public String deleteBus(@PathVariable long busId) {
        busService.deleteBus(busId);
        return "Bus deleted successfully!";
    }
}
