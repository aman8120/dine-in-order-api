package com.example.dio.mapper;

import com.example.dio.dto.request.FoodItemRequest;
import com.example.dio.dto.response.FoodItemResponse;
import com.example.dio.model.Category;
import com.example.dio.model.CuisineType;
import com.example.dio.model.FoodItem;
import org.mapstruct.Mapper;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface FoodItemMapper {

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

    default Category mapTOCategory(String category) {
        Category category1 = new Category();
        category1.setCategoryName(category);
        return category1;
    }


    default List<Category> map(List<String> categories) {
        if (categories == null || categories.isEmpty()) {
            return List.of();
        }
        return categories.stream()
                .map(this::mapTOCategory)
                .collect(Collectors.toList());
    }
}
