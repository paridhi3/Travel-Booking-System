package com.travelbookingsystem.travel.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "booking")
public class BookingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bookingId;

    private long userId;

    @Enumerated(EnumType.STRING)
    private TransportType transportType;

    private long transportId;
    private String seatNumber;

    @Enumerated(EnumType.STRING)
    private BookingStatus bookingStatus;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    private LocalDateTime bookingDate;
}

enum TransportType {
    TRAIN,
    FLIGHT,
    BUS
}

enum BookingStatus {
    CONFIRMED,
    CANCELLED
}

enum PaymentStatus {
    PENDING,
    COMPLETED,
    FAILED
}
