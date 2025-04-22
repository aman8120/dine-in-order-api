package com.example.dio.model;

import com.example.dio.enums.DietType;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "restaurant")
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurant_id")
    private long restaurantId;

    @Column(name = "restaurant_name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "contact_number")
    private String contactNumber;

    @Column(name = "contact_email")
    private String contactEmail;

    @Column(name = "opens_at")
    private LocalTime opensAt;

    @Column(name = "close_at")
    private LocalTime closesAt;

    @Column(name = "diet_type")
    @Enumerated(EnumType.STRING)
    private List<DietType> dietTypes;

    @Column(name = "created_at")
    @CreatedDate
    private LocalDate createdAt;

    @Column(name = "last_modified_at")
    @LastModifiedDate
    private LocalDate lastModifiedAt;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<CuisineType> cuisineTypes;

    @ManyToOne(fetch = FetchType.LAZY)
    private Admin admin;

    @OneToMany(mappedBy = "restaurant")
    private List<Tables> tables;

    @OneToMany(mappedBy = "restaurant", fetch = FetchType.EAGER)
    private List<FoodItem> foodItems;
}
