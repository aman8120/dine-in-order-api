package com.example.dio.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "cuisine_type")
@Getter
@Setter
public class CuisineType {

    @Id
    @Column(name = "cuisine_name")
    private String cuisineName;

    @ManyToMany(mappedBy = "cuisineTypes",cascade =CascadeType.ALL)
    private List<Restaurant> restaurants;

    @OneToMany(mappedBy = "cuisineType")
    private List<FoodItem> foodItems;

}

