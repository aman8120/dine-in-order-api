package com.example.dio.service;

import com.example.dio.dto.request.TableRequest;
import com.example.dio.dto.response.TableResponse;
import com.example.dio.model.Restaurant;
import jakarta.validation.Valid;

public interface TableService {

    TableResponse registerTable(@Valid TableRequest tableRequest, Restaurant restaurantId);
}
