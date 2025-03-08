package com.travelbookingsystem.travel.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalTime;
import com.fasterxml.jackson.annotation.JsonFormat;

@Data
@Entity
@Table(name = "train")
public class TrainEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long trainId;
    
    @Column(name = "train_name", nullable = false)
    private String trainName;
    
    @Column(name = "source", nullable = false)
    private String source;
    
    @Column(name = "destination", nullable = false)
    private String destination;
    
    @Column(name = "departure_time", nullable = false)
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime departureTime;
    
    @Column(name = "arrival_time", nullable = false)
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime arrivalTime;
    
    @Column(name = "total_seats", nullable = false)
    private int totalSeats;
    
    @Column(name = "available_seats", nullable = false)
    private int availableSeats;
    
    @Column(name = "price", nullable = false)
    private double price;

    @Enumerated(EnumType.STRING)
    @Column(name = "train_class", nullable = false)
    private TrainClass trainClass;
}


// Enum for Train Class
enum TrainClass {
    FIRST_CLASS,
    SECOND_CLASS,
    SLEEPER,
    GENERAL
}
