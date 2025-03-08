package com.travelbookingsystem.travel.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;

@Data
@Entity
@Table(name = "flight")
public class FlightEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long flightId;

    @Column(name = "airline_name", nullable = false)
    private String airlineName;
    
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
    @Column(name = "flight_class", nullable = false)
    private FlightClass flightClass;
}

enum FlightClass {
    ECONOMY,
    BUSINESS,
    FIRST_CLASS
}
