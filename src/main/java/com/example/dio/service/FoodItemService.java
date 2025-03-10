package com.example.dio.service;

import com.example.dio.dto.request.FoodItemRequest;
import com.example.dio.dto.response.FoodItemResponse;
import com.example.dio.model.Restaurant;
import jakarta.validation.Valid;

import java.util.List;

public interface FoodItemService {

    FoodItemResponse registerFoods(@Valid FoodItemRequest foodItemsRequest, Restaurant restaurantId);

}
