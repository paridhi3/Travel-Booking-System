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

    private String full_name;
    private String email;
    private String password;
    private String gender;
    private int age;
    private String contact;
}
