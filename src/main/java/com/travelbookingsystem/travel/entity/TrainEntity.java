package com.travelbookingsystem.travel.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalTime;

@Data
@Entity // Marks this class as a JPA entity, meaning it is mapped to a database table
@Table(name = "train") // Specifies the table name in the database. The table name will be "train"
public class TrainEntity {

    @Id // Marks the primary key of the entity.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Specifies auto-increment behavior for the primary key (trainId).
    private long trainId;

    private String trainName;
    private String source;
    private String destination;
    private LocalTime departureTime;
    private LocalTime arrivalTime;
    private int totalSeats;
    private int availableSeats;
    private double price;

    @Enumerated(EnumType.STRING) // Stores the enum value as a string in the database
    private TrainClass trainClass;
}

// Enum for Train Class
enum TrainClass {
    FIRST_CLASS,
    SECOND_CLASS,
    SLEEPER,
    GENERAL
}
