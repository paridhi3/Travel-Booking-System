package com.travelbookingsystem.travel.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity // Marks this class as a JPA entity, meaning it is mapped to a database table
@Table(name = "passenger") // Specifies the table name in the database. tble name will be "passenger"
public class PassengerEntity {

    @Id // Marks the primary key of the entity.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Specifies auto-increment behavior for the primary key (passengerId).
    private long passengerId;

    @Column(name = "full_name", nullable = false)
    private String full_name;
    
    @Column(name = "email", nullable = false)
    private String email;
    
    @Column(name = "password", nullable = false)
    private String password;
    
    @Column(name = "gender", nullable = false)
    private String gender;
    
    @Column(name = "age", nullable = false)
    private int age;
    
    @Column(name = "contact", nullable = false)
    private String contact;
}
