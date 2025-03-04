package com.example.dio.dto.request;

import com.example.dio.enums.UserRole;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class RegistrationRequest {

    @NotEmpty(message = "Username cannot be null or blank")
    @NotBlank(message = "User name cannot be blank")
    @Pattern(regexp = "^[a-zA-Z0-9_]+$", message = "Username can only contains Alphabets, Number and Underscore")
    public String username;

    @NotEmpty(message = "Email cannot be null or blank")
    @NotBlank(message = "Email name cannot be blank")
    @Email(regexp = "^[a-zA-Z0-9]+(?:[.+][a-zA-Z0-9]+)*@gmail\\.com$", message = "Email must be a valid Gmail address")
    public String email;


    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%^&*]).{8,}$", message = "Minimum 8 charachter ,Upper case,lower case, special character,numbers")
    @NotBlank(message = "Password cannot be blank")
    @NotNull(message = "Password cannot be null")
    public String password;


    @NotNull(message = "Phone number cannot be Null")
    @NotBlank(message = "Phone number cannot be Blanks")
    @Pattern(regexp = "^\\d{10}$", message = "Phone number must contain only digits and be exactly 10 digits long")
    public String phNo;

    public UserRole role;
}
