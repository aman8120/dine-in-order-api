package com.example.dio.model;

import com.example.dio.enums.DietType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "restaurant")
@Getter
@Setter
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurant_id")
    private long restaurantId;

    @Column(name = "restaurant_name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "contact_number")
    private String contactNumber;

    @Column(name = "contact_email")
    private String contactEmail;

    @Column(name = "opens_at")
    private LocalTime opensAt;

    @Column(name = "close_at")
    private LocalTime closesAt;

    @Column(name = "diet_type")
    @Enumerated(EnumType.STRING)
    private List<DietType> dietTypes;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "last_modified_at")
    private LocalDate lastModifiedAt;

    @ManyToMany(mappedBy = "restaurants", fetch = FetchType.EAGER)
    private List<CuisineType> cuisineTypes;

    @ManyToOne(fetch = FetchType.LAZY)
    private Admin admin;
}
