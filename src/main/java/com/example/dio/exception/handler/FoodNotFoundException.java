package com.example.dio.exception.handler;

public class FoodNotFoundException extends RuntimeException{
    public String messege;

    public FoodNotFoundException(String messege) {
        this.messege = messege;
    }

    public String getMessege() {
        return messege;
    }
    //    public RestaurantNotFoundException(String message) {
//        this.message = message;
//    }
//    public String getMessage(){
//        return this.message;
//    }
}
//table/tabelis/cart/food