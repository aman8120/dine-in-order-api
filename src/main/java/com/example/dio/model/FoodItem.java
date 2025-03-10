package com.example.dio.model;

import com.example.dio.enums.Availablity;
import com.example.dio.enums.DietType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "food_items")
@Getter
@Setter
public class FoodItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private long itemId;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private double price;

    @Column(name="description")
    private String description;

    @Column(name="stock")
    private int stock;

    @Column(name="availablity")
    private Availablity availability;

    @Column(name = "diet_types")
    private List<DietType> dietTypes;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "last_modified_at")
    private LocalDate lastModifiedAt;

    @ManyToOne
    private Restaurant restaurant;

    @ManyToOne
    private CuisineType cuisineType;
}
