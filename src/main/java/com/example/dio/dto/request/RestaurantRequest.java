package com.example.dio.dto.request;


import com.example.dio.enums.DietType;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
public class RestaurantRequest {

    @NotEmpty(message = "Username cannot be null or blank")
    @NotBlank(message = "User name cannot be blank")
    @Pattern(regexp = "^[a-zA-Z0-9_]+$", message = "Restaurant Name can only contains Alphabets, Number and Underscore")
    private String name;

    @NotEmpty(message = "Username cannot be null or blank")
    @NotBlank(message = "User name cannot be blank")
    @Pattern(regexp = "^[a-zA-Z0-9-]+$", message = "Address can only contains Alphabets, Number and Underscore")
    private String address;

    @NotNull(message = "Phone number cannot be Null")
    @NotBlank(message = "Phone number cannot be Blanks")
    @Pattern(regexp = "^\\d{10}$", message = "Phone number must contain only digits and be exactly 10 digits long")
    private String contactNumber;

    @NotEmpty(message = "Email cannot be null or blank")
    @NotBlank(message = "Email name cannot be blank")
    @Email(regexp = "^[a-zA-Z0-9]+(?:[.+][a-zA-Z0-9]+)*@gmail\\.com$", message = "Email must be a valid Gmail address")
    private String contactEmail;


    @NotNull(message = "Opening time cannot be null")
    private LocalTime opensAt;

    @NotNull(message = "Opening time cannot be null")
    private LocalTime closesAt;

    @Size(min = 1, message = "There must be at least one diet type")
    private List<DietType> dietTypes;

    @NotNull(message = "Cuisine types cannot be null")
    @NotEmpty(message = "At least one cuisine type must be provided")
    @Size(min = 1, message = "There must be at least one cuisine type")
    private List<String> cuisineTypes;
}
