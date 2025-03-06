package com.travelbookingsystem.travel.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "flight")
public class FlightEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long flightId;

    private String airlineName;
    private String source;
    private String destination;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private int totalSeats;
    private int availableSeats;
    private double price;

    @Enumerated(EnumType.STRING)
    private FlightClass flightClass;
}

enum FlightClass {
    ECONOMY,
    BUSINESS,
    FIRST_CLASS
}
