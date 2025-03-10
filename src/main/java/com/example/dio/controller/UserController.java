package com.example.dio.controller;

import com.example.dio.dto.request.RegistrationRequest;
import com.example.dio.dto.request.UserRequest;
import com.example.dio.dto.response.UserResponse;
import com.example.dio.model.User;
import com.example.dio.service.UserService;
import com.example.dio.util.FieldErrorResponse;
import com.example.dio.util.ResponseBuilder;
import com.example.dio.util.ResponseStructure;
import com.example.dio.util.SimpleErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("${app.base-url}")
@Tag(name = "User Controller", description = "Collection API Endpoint dealing user data")
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    @Operation(description = """
            The API Endpoint is used tp register user.
            The Endpoint requires the user to select one of the specified role among with the other details. 
            """, responses = {
            @ApiResponse(responseCode = "201", description = "User Created"),
            @ApiResponse(responseCode = "400", description = "Invalid Input", content = {
                    @Content(schema = @Schema(implementation = FieldErrorResponse.class))
            })
    })
    public ResponseEntity<ResponseStructure<UserResponse>> registerUser(@RequestBody @Valid RegistrationRequest registrationRequest) {

        UserResponse response = userService.registerUser(registrationRequest);


        return ResponseBuilder.success(HttpStatus.CREATED, "User Created", response);
    }

    @GetMapping("/users/{userId}")
    @Operation(description = """
            The API Endpoint is used tp find user.
            The Endpoint requires the user to select one of the specified role among with the other details. 
            """, responses = {
            @ApiResponse(responseCode = "200", description = "User Found", content = {
                    @Content(schema = @Schema(implementation = UserResponse.class))
            }),
            @ApiResponse(responseCode = "404", description = "User Not Found", content = {
                    @Content(schema = @Schema(implementation = SimpleErrorResponse.class))
            })
    })
    public ResponseEntity<ResponseStructure<UserResponse>> findUserById(@PathVariable long userId) {
        UserResponse response = userService.findUserById(userId);
        return ResponseBuilder.success(HttpStatus.OK, "User Found", response);
    }

    @PutMapping("/update/{userId}")
    @Operation(description = """
            The API Endpoint is used tp update user.
            The Endpoint requires the user to select one of the specified role among with the other details. 
            """, responses = {
            @ApiResponse(responseCode = "200", description = "User Found", content = {
                    @Content(schema = @Schema(implementation = UserRequest.class))
            }),
            @ApiResponse(responseCode = "404", description = "User Not Found", content = {
                    @Content(schema = @Schema(implementation = SimpleErrorResponse.class))
            })
    })
    public ResponseEntity<ResponseStructure<UserResponse>> updateUserById(@PathVariable long userId, @RequestBody @Valid UserRequest userRequest) {

        UserResponse response = userService.updateUserById(userId, userRequest);

        return ResponseBuilder.success(HttpStatus.OK, "User Updated", response);
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<ResponseStructure<String>> deleteUserById(@PathVariable long userId) {
        userService.deleteUserById(userId);
        return ResponseBuilder.success(HttpStatus.OK, "User Deleted ", "user");
    }


}

