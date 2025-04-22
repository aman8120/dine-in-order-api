package com.example.dio.repository;

import com.example.dio.model.CuisineType;
import com.example.dio.util.ResponseStructure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;


import java.util.List;

public interface CuisineTypeRepository extends JpaRepository<CuisineType,String> {

}
