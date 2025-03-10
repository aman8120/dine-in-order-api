package com.example.dio.controller;

import com.example.dio.dto.request.FoodItemRequest;
import com.example.dio.dto.response.FoodItemResponse;
import com.example.dio.model.Restaurant;
import com.example.dio.service.FoodItemService;
import com.example.dio.util.ResponseBuilder;
import com.example.dio.util.ResponseStructure;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class FoodItemController {

    private FoodItemService foodItemService;

    @PostMapping("/restaurant/{restaurantId}/foodItems")
    public ResponseEntity<ResponseStructure<FoodItemResponse>> registerFoods(@RequestBody @Valid FoodItemRequest foodItemsRequest, @PathVariable Restaurant restaurantId) {

        FoodItemResponse foodItemsResponse = foodItemService.registerFoods(foodItemsRequest, restaurantId);

        return ResponseBuilder.success(HttpStatus.CREATED, "FoodItems Created", foodItemsResponse);

    }
}
