package com.example.dio.mapper;

import com.example.dio.dto.request.FoodItemRequest;
import com.example.dio.dto.response.FoodItemResponse;
import com.example.dio.model.CuisineType;
import com.example.dio.model.FoodItem;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FoodItemsMapper {

    FoodItem mapToFoodItemsEntity(FoodItemRequest foodItemsRequest);

    FoodItemResponse mapTOFoodItemsResponse(FoodItem foodItems);

    default String mapToString(CuisineType cuisineType) {
        if (cuisineType == null) {
            return null;
        }

        return cuisineType.getCuisineName();
    }


    default CuisineType mapToCuisineType(String cuisineType) {

        if (cuisineType == null) {
            return null;
        }

        CuisineType cuisine = new CuisineType();
        cuisine.setCuisineName(cuisineType);
        return cuisine;
    }
}
