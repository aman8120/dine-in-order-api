package com.example.dio.service;

import com.example.dio.dto.response.CartItemResponse;
import com.example.dio.dto.response.FoodItemResponse;
import com.example.dio.dto.response.FoodResponse;

public interface CartItemService {
    public CartItemResponse addToCart(Long foodId, long tableId, int quantity);

    CartItemResponse updateQuantiyt(Long cartId, int quantity);
}
