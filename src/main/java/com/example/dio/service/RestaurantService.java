package com.example.dio.service;

import com.example.dio.dto.request.RestaurantRequest;
import com.example.dio.dto.response.RestaurantResponse;
import com.example.dio.model.User;
import jakarta.validation.Valid;

public interface RestaurantService {

    RestaurantResponse registerRestaurant(@Valid RestaurantRequest restaurantRequest, User userId);
}
