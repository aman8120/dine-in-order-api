package com.example.dio.service.imp;

import com.example.dio.dto.request.FoodItemRequest;
import com.example.dio.dto.response.FoodItemResponse;
import com.example.dio.exception.UserNotFoundByIdException;
import com.example.dio.mapper.FoodItemMapper;
import com.example.dio.model.CuisineType;
import com.example.dio.model.FoodItem;
import com.example.dio.model.Restaurant;
import com.example.dio.repository.CuisineTypeRepository;
import com.example.dio.repository.FoodItemRepository;
import com.example.dio.repository.RestaurantRepository;
import com.example.dio.service.FoodItemService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class FoodItemServiceImpl implements FoodItemService {
    private FoodItemRepository foodItemRepository;
    private RestaurantRepository restaurantRepository;
    private CuisineTypeRepository cuisineTypeRepository;
    private FoodItemMapper foodItemsMapper;

    @Override
    public FoodItemResponse registerFoods(FoodItemRequest foodItemRequest, Restaurant restaurantId) {

        Restaurant existingRestaurant = restaurantRepository.findById(restaurantId.getRestaurantId())
                .orElseThrow(() -> new UserNotFoundByIdException("Restaurant not found"));

        FoodItem foodItem = foodItemsMapper.mapToFoodItemsEntity(foodItemRequest);
        CuisineType cuisineType = createCuisineIfNotExist(foodItem.getCuisineType());
        foodItem.setCuisineType(cuisineType);
        foodItem.setRestaurant(existingRestaurant);

        foodItemRepository.save(foodItem);

        return foodItemsMapper.mapTOFoodItemsResponse(foodItem);


    }

    private CuisineType createCuisineIfNotExist(CuisineType cuisineType) {

        return cuisineTypeRepository.findById(cuisineType.getCuisineName())
                        .orElseGet(() -> cuisineTypeRepository.save(cuisineType));
    }
}
