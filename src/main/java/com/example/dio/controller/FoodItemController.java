package com.example.dio.controller;

import com.example.dio.dto.request.FoodItemRequest;
import com.example.dio.dto.response.FoodItemResponse;
import com.example.dio.model.Category;
import com.example.dio.model.FoodItem;
import com.example.dio.model.Restaurant;
import com.example.dio.service.FoodItemService;
import com.example.dio.util.ResponseBuilder;
import com.example.dio.util.ResponseStructure;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("${app.base-url}")
public class FoodItemController {

    private FoodItemService foodItemService;

    @PostMapping("/restaurants/{restaurantId}/foodItems")
    public ResponseEntity<ResponseStructure<FoodItemResponse>> registerFoods(@RequestBody @Valid FoodItemRequest foodItemRequest, @PathVariable Restaurant restaurantId) {

        FoodItemResponse foodItemResponse = foodItemService.registerFoods(foodItemRequest, restaurantId);

        return ResponseBuilder.success(HttpStatus.CREATED, "FoodItems Created", foodItemResponse);

    }

    @GetMapping("/foodItems/categories/{categories}")
    public ResponseEntity<ResponseStructure<List<FoodItemResponse>>> findFoodItemsByCategories(@PathVariable List<String> categories) {

        List<FoodItemResponse> foodItemResponse = foodItemService.findFoodItemsByCategories(categories);

        return ResponseBuilder.ok("Category Found", foodItemResponse);
    }

    @GetMapping("/restaurant/{id}/fooditems")
    public ResponseEntity<ResponseStructure<List<FoodItemResponse>>> fetchAll(@PathVariable long id){
        List<FoodItemResponse> responses=foodItemService.fetchAll(id);
        return ResponseBuilder.ok("fected all the food item based on the restarant",responses);
    }
}
