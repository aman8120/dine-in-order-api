package com.example.dio.controller;

import com.example.dio.dto.request.RegistrationRequest;
import com.example.dio.dto.request.RestaurantRequest;
import com.example.dio.dto.response.RestaurantResponse;
import com.example.dio.mapper.RestaurantMapperImpl;
import com.example.dio.model.User;
import com.example.dio.service.RestaurantService;
import com.example.dio.service.imp.RestaurantServiceImpl;
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
public class RestaurantController {

    private final RestaurantService restaurantService;

    @PostMapping("/users/{userId}/restaurant")
    public ResponseEntity<ResponseStructure<RestaurantResponse>> registerRestaurant(@RequestBody @Valid RestaurantRequest restaurantRequest, @PathVariable User userId) {
        System.out.println("Creating Restaurant");
        RestaurantResponse restaurantResponse = restaurantService.registerRestaurant(restaurantRequest,userId);

        return ResponseBuilder.success(HttpStatus.CREATED, "User Created", restaurantResponse);
    }


}
