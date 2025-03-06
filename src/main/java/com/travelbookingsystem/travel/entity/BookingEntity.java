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

    @ManyToOne
    @JoinColumn(name = "passenger_id", nullable = false)
    private PassengerEntity passenger;  // Foreign key reference to UserEntity

    @Enumerated(EnumType.STRING)
    @Column(name = "transport_type", nullable = false)
    private TransportType transportType;

    @Column(name = "transport_id", nullable = false)
    private long transportId;
    
    @Column(name = "seat_number", length = 10, nullable = false)
    private String seatNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "booking_status", nullable = false)
    private BookingStatus bookingStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_status", nullable = false)
    private PaymentStatus paymentStatus = PaymentStatus.PENDING; // Default value;
    
    @Column(name = "booking_date", nullable = false, updatable = false)
    private LocalDateTime bookingDate;

    @PrePersist
    protected void onCreate() {
        if (bookingDate == null) {
            bookingDate = LocalDateTime.now();
        }
    }
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
