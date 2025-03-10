package com.example.dio.dto.request;

import com.example.dio.enums.DietType;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FoodItemRequest {

    @NotEmpty(message = "Username cannot be null or blank")
    @NotBlank(message = "User name cannot be blank")
    @Pattern(regexp = "^[a-zA-Z0-9_]+$", message = "Restaurant Name can only contains Alphabets, Number and Underscore")
    private String name;

    @NotNull(message = "price cannot be null")
    private double price;

    @NotEmpty(message = "Username cannot be null or blank")
    @NotBlank(message = "User name cannot be blank")
    @Pattern(regexp = "^[a-zA-Z0-9_]+$", message = "Restaurant Name can only contains Alphabets, Number and Underscore")
    private String description;

    @NotNull(message = "stock must be not null")
    @Min(value = 0)
    private int stock;

    @Size(min = 1, message = "There must be at least one diet type")
    private List<DietType> dietTypes;

    @NotNull(message = "Cuisine type cannot be null")
    @NotEmpty(message = "At least one cuisine type must be provided")
    @Size(min = 1, message = "There must be at least one cuisine type")
    private String cuisineType;

}
