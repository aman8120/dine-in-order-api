package com.example.dio.repository;

import com.example.dio.model.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodItemsRepository extends JpaRepository<FoodItem, Long> {
}
