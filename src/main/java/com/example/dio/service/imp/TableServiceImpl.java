package com.example.dio.service.imp;

import com.example.dio.dto.request.TableRequest;
import com.example.dio.dto.response.TableResponse;
import com.example.dio.exception.UserNotFoundByIdException;
import com.example.dio.mapper.TableMapper;
import com.example.dio.model.Restaurant;
import com.example.dio.model.Tables;
import com.example.dio.repository.RestaurantRepository;
import com.example.dio.repository.TableRepository;
import com.example.dio.service.TableService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TableServiceImpl implements TableService {

    private TableRepository tableRepository;
    private RestaurantRepository restaurantRepository;
    private TableMapper tableMapper;

    @Override
    public TableResponse registerTable(TableRequest tableRequest, Restaurant restaurantId) {
        Restaurant foundRestaurant = restaurantRepository.findById(restaurantId.getRestaurantId())
                .orElseThrow(() -> new UserNotFoundByIdException("Resturant Not Found By Id "));

        Tables tables = tableMapper.mapToTableEntity(tableRequest);
        tables.setRestaurant(foundRestaurant);

        tableRepository.save(tables);
        return tableMapper.mapToTableResponse(tables);

    }
}
