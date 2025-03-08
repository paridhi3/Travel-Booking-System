package com.travelbookingsystem.travel.service;

import com.travelbookingsystem.travel.model.Train;
import com.travelbookingsystem.travel.repository.TrainRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * TrainService Methods:
 * 1. saveTrain(Train train) -> int
 * 2. getAllTrains() -> List<Train>
 * 3. getTrainById(long trainId) -> Train
 * 4. updateTrain(Train train) -> int
 * 5. updateAvailableSeats(Long trainId, int seatChange) -> int
 * 6. deleteTrainById(long trainId) -> int
 * 7. getTrainsBySourceAndDestination(String source, String destination) -> List<Train>
 * 8. getTrainsByPriceRange(double minPrice, double maxPrice) -> List<Train>
 */

@Service
public class TrainService {
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

    public int updateAvailableSeats(Long trainId, int seatChange) {
        return trainRepository.updateAvailableSeats(trainId, seatChange);
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
