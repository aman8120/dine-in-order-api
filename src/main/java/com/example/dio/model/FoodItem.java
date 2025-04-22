package com.example.dio.model;

import com.example.dio.enums.Availablity;
import com.example.dio.enums.DietType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "food_items",indexes = {
        @Index(name = "idx_name",columnList = "item_name")
})
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class FoodItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private long itemId;

    @Column(name = "item_name")
    private String name;

    @Column(name = "price")
    private double price;

    @Column(name="description")
    private String description;

    @Column(name="stock")
    private int stock;

    @Column(name="availablity")
    private Availablity availability;

    @Column(name = "diet_types")
    private List<DietType> dietTypes;

    @Column(name = "created_at")
    @CreatedDate
    private LocalDate createdAt;

    @Column(name = "last_modified_at")
    @LastModifiedDate
    private LocalDate lastModifiedAt;

    @ManyToOne
    private Restaurant restaurant;

    @ManyToOne
    private CuisineType cuisineType;

    @ManyToMany
    private List<Category> categories;

    @OneToMany(mappedBy = "foodItem")
    private List<CartItem> cartItems; // Must be a collection (List or Set)
}
