package com.example.dio.model;

import jakarta.persistence.*;
import lombok.Getter;
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

    @ManyToMany
    private List<Restaurant> restaurants;
}
