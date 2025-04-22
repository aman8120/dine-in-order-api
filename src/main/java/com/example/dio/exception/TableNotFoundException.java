package com.example.dio.exception;

import com.example.dio.repository.TableRepository;

public class TableNotFoundException extends RuntimeException{
    private String message;

    public TableNotFoundException(String message){
        this.message=message;
    }

    public String getMessage() {
        return message;
    }
}
