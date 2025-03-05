package com.example.dio.util;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseStructure<T> {

    private int status;
    private String message;
    private T data;

    /**
     * Creates a new {@link ResponseStructure} instance with the given status, message, and data.
     *
     * @param status  The HTTP status of the response.
     * @param message The message describing the response.
     * @param data    The response data.
     * @param <T>     The type of the response data.
     * @return A new {@link ResponseStructure} instance with the provided values.
     */
    public static <T> ResponseStructure<T> create(HttpStatus status, String message, T data) {
        ResponseStructure<T> response = new ResponseStructure<>();
        response.status = status.value();
        response.message = message;
        response.data = data;
        return response;
    }

}
