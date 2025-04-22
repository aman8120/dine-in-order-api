package com.example.dio.exception;

public class RestaurantNotFoundException  extends RuntimeException {
  private String message;

  public RestaurantNotFoundException(String message) {
    this.message = message;
  }
  public String getMessage(){
    return this.message;
  }
}

