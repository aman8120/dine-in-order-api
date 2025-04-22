package com.example.dio.repository;

import com.example.dio.model.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodItemRepository extends JpaRepository<FoodItem, Long> {

    @Query("SELECT fi FROM FoodItem fi JOIN fi.categories c " +
            "WHERE c.categoryName IN :categories " +  // Use categoryName instead of category
            "GROUP BY fi " +
            "HAVING COUNT(DISTINCT c.categoryName) = :categoryCount")
    List<FoodItem> findFoodItemsByCategoryNames(@Param("categories") List<String> categories,
                                                @Param("categoryCount") long categoryCount);

    @Query("SELECT f FROM FoodItem f WHERE f.restaurant.restaurantId = :restaurantId")
    List<FoodItem> findByRestaurantId(long restaurantId);
}