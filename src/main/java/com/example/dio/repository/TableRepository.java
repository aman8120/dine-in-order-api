package com.example.dio.repository;

import com.example.dio.model.Tables;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TableRepository extends JpaRepository<Tables, Long> {


}
