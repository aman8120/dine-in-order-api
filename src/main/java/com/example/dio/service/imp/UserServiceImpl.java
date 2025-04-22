package com.example.dio.service.imp;

import com.example.dio.dto.request.RegistrationRequest;
import com.example.dio.dto.request.UserRequest;
import com.example.dio.dto.response.UserResponse;
import com.example.dio.enums.UserRole;
import com.example.dio.exception.UserNotFoundByIdException;
import com.example.dio.mapper.UserMapper;
import com.example.dio.model.Admin;
import com.example.dio.model.Staff;
import com.example.dio.model.User;
import com.example.dio.repository.UserRepository;
import com.example.dio.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    /**
     * Registers a new user based on the provided role.
     *
     * @param registrationRequest The request containing user registration details.
     * @return The response containing registered user details.
     */
    @Override
    public UserResponse registerUser(RegistrationRequest registrationRequest) {

        User user = this.createUserByRole(registrationRequest.getRole());
        userMapper.mapToUserEntity(registrationRequest, user);
        userRepository.save(user);
        return userMapper.mapToUserResponse(user);

    }

    /**
     * Retrieves a user by their unique ID.
     *
     * @param userId The unique identifier of the user.
     * @return The response containing user details if found.
     * @throws UserNotFoundByIdException If the user is not found by the given ID.
     */
    @Override
    public UserResponse findUserById(long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundByIdException("Failed to find user,user not found by id"));
        return userMapper.mapToUserResponse(user);
    }

    /**
     * Updates an existing user's details.
     *
     * @param userId     The unique identifier of the user to be updated.
     * @param userRequest The request containing updated user information.
     * @return The response containing updated user details.
     * @throws UserNotFoundByIdException If the user is not found by the given ID.
     */
    @Override
    public UserResponse updateUserById(long userId, UserRequest userRequest) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundByIdException("Failed to find user ,user not found by id"));
        userMapper.mapToUserEntity(userRequest, user);
        userRepository.save(user);
        return userMapper.mapToUserResponse(user);

        //______________________________________OLD CODE_______________________________________________________
//        Optional<User> optionalUser = userRepository.findById(userId);
//        if (optionalUser.isPresent()) {
//            User existingUser = optionalUser.get();
//            mapToNewUser(updatedUser, existingUser);
//            return userRepository.save(existingUser);
//        } else {
//            throw new UserNotFoundByIdException("Failed to update user, user not found by id");
//        }
    }

    /**
     * Deletes a user from the system by their unique ID.
     *
     * @param userId The unique identifier of the user to be deleted.
     * @throws UserNotFoundByIdException If the user is not found by the given ID.
     */
    @Override
    public void deleteUserById(long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            userRepository.deleteById(userId);
        } else {
            throw new UserNotFoundByIdException("Failed to delete user, user not found by id");
        }
    }

    /**
     * Creates a user instance based on the provided role.
     *
     * @param role The role of the user (ADMIN or STAFF).
     * @return The newly created user instance.
     * @throws RuntimeException If the provided role is invalid.
     */
    private static User createUserByRole(UserRole role) {
        User user;

        switch (role) {
            case ADMIN -> user = new Admin();
            case STAFF -> user = new Staff();
            default -> throw new RuntimeException("Failed to register user ,invalid user");
        }
        return user;
    }
}
