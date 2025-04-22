package com.example.dio.dto.response;

import com.example.dio.enums.Availablity;
import com.example.dio.enums.DietType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class FoodItemResponse {

    private String name;
    private double price;
    private String description;
    private Availablity availability;
    private List<DietType> dietTypes;
    private String cuisineType;
    private LocalDate createdAt;
    private LocalDate lastModifiedAt;
}
