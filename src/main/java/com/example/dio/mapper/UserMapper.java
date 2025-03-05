package com.example.dio.mapper;

import com.example.dio.dto.request.RegistrationRequest;
import com.example.dio.dto.request.UserRequest;
import com.example.dio.dto.response.UserResponse;
import com.example.dio.model.User;
import lombok.NoArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.context.annotation.Bean;

/**
 * Mapper interface for converting between user-related DTOs and entity objects.
 * Utilizes MapStruct for object mapping.
 */
@Mapper(componentModel = "spring")
public interface UserMapper {

    /**
     * Maps a {@link RegistrationRequest} DTO to a {@link User} entity.
     *
     * @param registrationRequest The registration request containing user details.
     * @param user                The target user entity to be updated with the mapped values.
     */
    void mapToUserEntity(RegistrationRequest registrationRequest, @MappingTarget User user);

    /**
     * Maps a {@link UserRequest} DTO to an existing {@link User} entity.
     *
     * @param userRequest The user request containing updated user details.
     * @param user        The target user entity to be updated with the mapped values.
     */
    void mapToUserEntity(UserRequest userRequest, @MappingTarget User user);

    /**
     * Maps a {@link User} entity to a {@link UserResponse} DTO.
     *
     * @param user The user entity to be mapped.
     * @return A {@link UserResponse} containing the mapped user details.
     */
    UserResponse mapToUserResponse(User user);

}
