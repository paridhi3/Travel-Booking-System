package com.travelbookingsystem.travel.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;

@Data
@Entity
@Table(name = "bus")
public class BusEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long busId;

    @Column(name = "bus_name", nullable = false)
    private String busName;
    
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
    @Column(name = "bus_class", nullable = false)
    private BusClass busClass;
}

enum BusClass {
    SLEEPER,
    SEMI_SLEEPER,
    SEATER,
    AC,
    NON_AC
}
