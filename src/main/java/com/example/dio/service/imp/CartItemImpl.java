package com.example.dio.service.imp;

import com.example.dio.dto.response.CartItemResponse;
import com.example.dio.dto.response.FoodResponse;
import com.example.dio.exception.CartNotFoundException;
import com.example.dio.exception.TableNotFoundException;
import com.example.dio.exception.handler.FoodNotFoundException;
import com.example.dio.mapper.CartItemMapper;
import com.example.dio.model.CartItem;
import com.example.dio.model.FoodItem;
import com.example.dio.model.Tables;
import com.example.dio.repository.CartItemRepository;
import com.example.dio.repository.FoodItemRepository;
import com.example.dio.repository.TableRepository;
import com.example.dio.service.CartItemService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class CartItemImpl implements CartItemService {
    private final CartItemRepository cartItemRepository;
    private final FoodItemRepository foodItemRepository;
    private final TableRepository tableRepository;
    private final CartItemMapper cartItemMapper;

    @Override
    public CartItemResponse addToCart(Long foodId, long tableId, int quantity) {

        FoodItem foodItem = foodItemRepository.findById(foodId)
                .orElseThrow(() -> new FoodNotFoundException("Requested food ID not available"));


        Tables restaurantTable = tableRepository.findById(tableId)
                .orElseThrow(() -> new TableNotFoundException("table not found"));


        CartItem cartItem=new CartItem();
        cartItem.setFoodItem(foodItem);
        cartItem.setRestaurantTable(restaurantTable);
        cartItem.setQuantity(quantity);
        cartItem.setTotalPrice(calculateTotalPrice(foodItem,quantity));
        cartItemRepository.save(cartItem);

        return cartItemMapper.mapToCartItemResponse(cartItem);


    }

    @Override
    public CartItemResponse updateQuantiyt(Long cartId, int quantity) {
        CartItem cartItem = cartItemRepository.findById(cartId)
                .orElseThrow(() -> new CartNotFoundException("Cart is not available"));


        cartItem.setQuantity(quantity);
        cartItem.setTotalPrice(quantity * cartItem.getFoodItem().getPrice());


        System.out.println(cartItem);

        cartItemRepository.save(cartItem);

        CartItemResponse response= cartItemMapper.mapToCartItemResponse(cartItem);
        response.setTotalPrice(cartItem.getTotalPrice());
        response.setItemId((int)cartItem.getRestaurantTable().getTableId());
        return response;
    }

    public double calculateTotalPrice(FoodItem foodItem,int quantity){
        return foodItem.getPrice()*quantity;

    }
}
