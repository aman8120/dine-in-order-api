package com.example.dio.model;

import com.example.dio.enums.TableStatus;
import jakarta.persistence.*;
import jakarta.validation.Constraint;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tables")
@Getter
@Setter
public class Tables {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "table_id")
    private long tableId;

    @Column(name = "table_no")
    private String tableNo;

    @Column(name = "table_capacity")
    private String tableCapacity;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private TableStatus status;

    @ManyToOne
    private Restaurant restaurant;

}
