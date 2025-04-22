package com.example.dio.controller;

import com.example.dio.dto.request.TableRequest;
import com.example.dio.dto.response.TableResponse;
import com.example.dio.model.Restaurant;
import com.example.dio.service.TableService;
import com.example.dio.util.ResponseBuilder;
import com.example.dio.util.ResponseStructure;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("${app.base-url}")
public class TableController {

    private TableService tableService;

    @PostMapping("/restaurants/{restaurantId}/tables")
    public ResponseEntity<ResponseStructure<TableResponse>> registerTable(@RequestBody @Valid TableRequest tableRequest, @PathVariable Restaurant restaurantId) {

        TableResponse tableResponse = tableService.registerTable(tableRequest,restaurantId);

        return ResponseBuilder.success(HttpStatus.CREATED, "Table Created", tableResponse);
    }

}
