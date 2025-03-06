package com.travelbookingsystem.travel.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "admin")
public class AdminEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long adminId;

    private String fullName;
    private String email;
    private String password;
}
