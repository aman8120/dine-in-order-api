package com.example.dio.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FoodResponse {


    private long cartId;
    private int tableId;
    private double totalprice;
    private int quantity;
}
