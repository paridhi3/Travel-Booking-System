package com.travelbookingsystem.travel.service;

import com.travelbookingsystem.travel.model.Train;
import com.travelbookingsystem.travel.repository.TrainRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainService {
    private final TrainRepository trainRepository;

    public TrainService(TrainRepository trainRepository) {
        this.trainRepository = trainRepository;
    }

    // Retrieve all trains
    public List<Train> getAllTrains() {
        return trainRepository.findAll();
    }

    // Retrieve a train by ID
    public Train getTrainById(long trainId) {
        return trainRepository.findById(trainId);
    }

    // Add a new train
    public void addTrain(Train train) {
        trainRepository.save(train);
    }

    // Update train details
    public void updateTrain(Train train) {
        trainRepository.update(train);
    }

    // Delete a train by ID
    public void deleteTrain(long trainId) {
        trainRepository.deleteById(trainId);
    }

    // Find trains by source and destination
    public List<Train> getTrainsByRoute(String source, String destination) {
        return trainRepository.findBySourceAndDestination(source, destination);
    }

    // Find trains within a price range
    public List<Train> getTrainsByPriceRange(double minPrice, double maxPrice) {
        return trainRepository.findByPriceBetween(minPrice, maxPrice);
    }
}
