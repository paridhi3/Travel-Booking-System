package com.travelbookingsystem.travel.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@Entity // Marks this class as a JPA entity, meaning it is mapped to a database table
@Table(name = "train") // Specifies the table name in the database. The table name will be "train"
public class TrainEntity {

    @Id // Marks the primary key of the entity.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Specifies auto-increment behavior for the primary key (trainId).
    private long trainId;
    
    @Column(name = "train_name", nullable = false)
    private String trainName;
    
    @Column(name = "source", nullable = false)
    private String source;
    
    @Column(name = "destination", nullable = false)
    private String destination;
    
    @Column(name = "departure_time", nullable = false)
    private LocalDateTime departureTime;
    
    @Column(name = "arrival_time", nullable = false)
    private LocalDateTime arrivalTime;
    
    @Column(name = "total_seats", nullable = false)
    private int totalSeats;
    
    @Column(name = "available_seats", nullable = false)
    private int availableSeats;
    
    @Column(name = "price", nullable = false)
    private double price;

    @Enumerated(EnumType.STRING) // Stores the enum value as a string in the database
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
