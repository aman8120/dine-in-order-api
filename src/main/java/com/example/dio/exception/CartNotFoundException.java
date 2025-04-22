package com.example.dio.exception;

public class CartNotFoundException extends RuntimeException{
    private String messege;

    public CartNotFoundException(String messege) {
        this.messege=messege;

    }

    public String getMessege() {
        return messege;
    }
}
