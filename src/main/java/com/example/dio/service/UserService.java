package com.example.dio.service;

import com.example.dio.dto.request.RegistrationRequest;
import com.example.dio.dto.request.UserRequest;
import com.example.dio.dto.response.UserResponse;
import com.example.dio.model.User;

public interface UserService {

    /**
     * Registers a new user in the system.
     *
     * @param user The registration request containing user details.
     * @return The response containing registered user details.
     */
    UserResponse registerUser(RegistrationRequest user);

    /**
     * Retrieves a user by their unique ID.
     *
     * @param id The unique identifier of the user.
     * @return The response containing user details if found.
     */
    UserResponse findUserById(long id);

    /**
     * Updates an existing user's details.
     *
     * @param userId The unique identifier of the user to be updated.
     * @param updatedUser The request containing updated user information.
     * @return The response containing updated user details.
     */
    UserResponse updateUserById(long userId, UserRequest updatedUser);

    /**
     * Deletes a user from the system by their unique ID.
     *
     * @param userId The unique identifier of the user to be deleted.
     */
    void deleteUserById(long userId);
}
