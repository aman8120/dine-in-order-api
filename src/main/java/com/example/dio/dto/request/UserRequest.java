package com.example.dio.dto.request;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {

    @NotEmpty(message = "Username cannot be null or blank")
    @NotBlank(message = "User name cannot be blank")
    @Pattern(regexp = "^[a-zA-Z0-9_]+$", message = "Username can only contains Alphabets, Number and Underscore")
    public String username;

    @NotEmpty(message = "Email cannot be null or blank")
    @NotBlank(message = "Email name cannot be blank")
    @Email(regexp = "^[a-zA-Z0-9]+(?:[.+][a-zA-Z0-9]+)*@gmail\\.com$", message = "Email must be a valid Gmail address")
    public String email;

    @NotNull(message = "Phone number cannot be Null")
    @NotBlank(message = "Phone number cannot be Blanks")
    @Pattern(regexp = "^\\d{10}$", message = "Phone number must contain only digits and be exactly 10 digits long")
    public String phNo;
}
