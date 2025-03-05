package com.example.dio.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class ResponseBuilder {

    /**
     * Builds a success response with the provided HTTP status, message, and data.
     *
     * @return ResponseEntity of type ResponseStructure or type T (the type of the data).
     * @Param status the status of the operation
     * @Param message the message to then user
     * @Param data the data involved in the operation
     */
    public static <T> ResponseEntity<ResponseStructure<T>> success(HttpStatus status, String message, T data) {
        ResponseStructure<T> structure = ResponseStructure.<T>builder()
                .status(status.value())
                .message(message)
                .data(data)
                .build();

        return ResponseEntity.status(status)
                .body(structure);
    }

    /**
     * Builds a success response with HTTP status 201 CREATED.
     *
     * @param message A descriptive message for the response.
     * @param data    The data payload to include in the response.
     * @param <T>     The type of the data payload.
     * @return A ResponseEntity containing a ResponseStructure with status 201 CREATED, the specified message, and data.
     */
    public static <T> ResponseEntity<ResponseStructure<T>> created(String message, T data) {
        return success(HttpStatus.CREATED, message, data);
    }

    /**
     * Builds a success response with HTTP status 200 OK.
     *
     * @param message A descriptive message for the response.
     * @param data    The data payload to include in the response.
     * @param <T>     The type of the data payload.
     * @return A ResponseEntity containing a ResponseStructure with status 200 OK, the specified message, and data.
     */
    public static <T> ResponseEntity<ResponseStructure<T>> ok(String message, T data) {
        return success(HttpStatus.OK, message, data);
    }

    /**
     * Builds an error response with HTTP status 404 NOT FOUND.
     *
     * @param message A descriptive error message.
     * @return A ResponseEntity containing a SimpleErrorResponse with status 404 NOT FOUND and the specified message.
     */
    public static <T> ResponseEntity<SimpleErrorResponse> notFound(String message) {
        return error(HttpStatus.NOT_FOUND, message);
    }

    /**
     * Builds an error response with the provided HTTP status and message.
     *
     * @param status  The HTTP status code (e.g., HttpStatus.BAD_REQUEST, HttpStatus.INTERNAL_SERVER_ERROR).
     * @param message A descriptive error message.
     * @return A ResponseEntity containing a SimpleErrorResponse with the specified status and message.
     */
    public static ResponseEntity<SimpleErrorResponse> error(HttpStatus status, String message) {
        SimpleErrorResponse error = SimpleErrorResponse.builder()
                .type(status.name())
                .message(message)
                .status(status.value())
                .build();

        return ResponseEntity.status(status).body(error);

    }


}
