package com.travelbookingsystem.travel.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "bus")
public class BusEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long busId;

    private String busName;
    private String source;
    private String destination;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private int totalSeats;
    private int availableSeats;
    private double price;

    @Enumerated(EnumType.STRING)
    private BusClass busClass;
}

enum BusClass {
    SLEEPER,
    SEMI_SLEEPER,
    SEATER,
    AC,
    NON_AC
}
