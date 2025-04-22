package com.example.dio.controller;

import com.example.dio.dto.response.CartItemResponse;
import com.example.dio.dto.response.FoodItemResponse;
import com.example.dio.dto.response.FoodResponse;
import com.example.dio.service.CartItemService;
import com.example.dio.util.ResponseBuilder;
import com.example.dio.util.ResponseStructure;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${app.base-url}/cart")
@AllArgsConstructor
public class CartItemController {
    private CartItemService cartItemService;

    @PostMapping("/add/{foodId}/{tableId}")
    public ResponseEntity<ResponseStructure<CartItemResponse>> addToCart(@PathVariable Long foodId, @PathVariable long tableId, @RequestParam int quantity) {
        System.out.println("reached the controller");
        CartItemResponse response = cartItemService.addToCart(foodId, tableId, quantity);
        return ResponseBuilder.created("Cart Added", response);
    }

    @PatchMapping("cartItem/{cartId}/{quantity}")
    public ResponseEntity<ResponseStructure<CartItemResponse>> updateQuantity(@PathVariable Long cartId, @PathVariable int quantity) {
      CartItemResponse   response = cartItemService.updateQuantiyt(cartId, quantity);

        return ResponseBuilder.ok("quantity updated successfully", response);

    }
}
