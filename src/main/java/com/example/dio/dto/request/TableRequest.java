package com.example.dio.dto.request;

import com.example.dio.enums.TableStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TableRequest {

    @NotEmpty(message = "TableNo cannot be null or blank")
    @NotBlank(message = "TableNo cannot be blank")
    @Pattern(regexp = "^[0-9_]+$", message = "TableNo can only  Number and Underscore")
    private String tableNo;

    @NotEmpty(message = "Table Capacity cannot be null or blank")
    @NotBlank(message = "Table  Capacity cannot be blank")
    @Pattern(regexp = "^[0-9_]+$", message = "Table Capacity can only  Number and Underscore")
    private String tableCapacity;

    private TableStatus status;
}
