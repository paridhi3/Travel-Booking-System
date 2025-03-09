package com.travelbookingsystem.travel.service;

import com.travelbookingsystem.travel.model.Train;
import com.travelbookingsystem.travel.repository.TrainRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/*
 * TrainService Methods:
 * 1. saveTrain(Train train) -> int
 * 2. getAllTrains() -> List<Train>
 * 3. getTrainById(long trainId) -> Train
 * 4. updateTrain(Train train) -> int
 * 5. reduceAvailableSeats(Long trainId) -> boolean
 * 6. deleteTrainById(long trainId) -> int
 * 7. getTrainsBySourceAndDestination(String source, String destination) -> List<Train>
 * 8. getTrainsByPriceRange(double minPrice, double maxPrice) -> List<Train>
 */

@Service
public class TrainService {
	
	@Autowired
    private final TrainRepository trainRepository;

    public TrainService(TrainRepository trainRepository) {
        this.trainRepository = trainRepository;
    }

    public int saveTrain(Train train) {
        return trainRepository.save(train);
    }

    public List<Train> getAllTrains() {
        return trainRepository.findAll();
    }

    public Train getTrainById(long trainId) {
        return trainRepository.findById(trainId);
    }

    public int updateTrain(Train train) {
        return trainRepository.update(train);
    }
    
    // Update available seats when a booking is made   
    @Transactional
    public boolean reduceAvailableSeats(Long trainId) {
        Train train = trainRepository.findById(trainId);
        
        if (train == null) {
            System.out.println("Train not found with ID: " + trainId);
            return false;
        }

        if (train.getAvailableSeats() <= 0) {
            System.out.println("No available seats for Train ID: " + trainId);
            return false;
        }
        
        System.out.println("Before Update: Available Seats = " + train.getAvailableSeats());

        int rowsUpdated = trainRepository.updateAvailableSeats(trainId, 1);
        train.setAvailableSeats(train.getAvailableSeats() - 1);
        
        System.out.println("After Update: Available Seats = " + train.getAvailableSeats());
        
        return rowsUpdated > 0;
    }


    public int deleteTrainById(long trainId) {
        return trainRepository.deleteById(trainId);
    }

    public List<Train> getTrainsBySourceAndDestination(String source, String destination) {
        return trainRepository.findBySourceAndDestination(source, destination);
    }

    public List<Train> getTrainsByPriceRange(double minPrice, double maxPrice) {
        return trainRepository.findByPriceBetween(minPrice, maxPrice);
    }
}
