package com.travelbookingsystem.travel.controller;

import com.travelbookingsystem.travel.model.Train;
import com.travelbookingsystem.travel.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trains")
public class TrainController {

    @Autowired
    private TrainService trainService;

    // Retrieve all trains
    @GetMapping
    public List<Train> getAllTrains() {
        return trainService.getAllTrains();
    }

    // Retrieve a train by ID
    @GetMapping("/{trainId}")
    public Train getTrainById(@PathVariable long trainId) {
        return trainService.getTrainById(trainId);
    }

    // Add a new train
    @PostMapping
    public String addTrain(@RequestBody Train train) {
        trainService.addTrain(train);
        return "Train added successfully!";
    }

    // Update train details
    @PutMapping("/{trainId}")
    public String updateTrain(@PathVariable long trainId, @RequestBody Train train) {
        train.setTrainId(trainId);
        trainService.updateTrain(train);
        return "Train details updated successfully!";
    }

    // Delete a train by ID
    @DeleteMapping("/{trainId}")
    public String deleteTrain(@PathVariable long trainId) {
        trainService.deleteTrain(trainId);
        return "Train deleted successfully!";
    }

    // Find trains by source and destination
    @GetMapping("/route")
    public List<Train> getTrainsByRoute(@RequestParam String source, @RequestParam String destination) {
        return trainService.getTrainsByRoute(source, destination);
    }

    // Find trains within a price range
    @GetMapping("/price-range")
    public List<Train> getTrainsByPriceRange(@RequestParam double minPrice, @RequestParam double maxPrice) {
        return trainService.getTrainsByPriceRange(minPrice, maxPrice);
    }
}
