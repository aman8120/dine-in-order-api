package com.example.dio.exception.handler;

import com.example.dio.util.FieldErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;
@RestControllerAdvice
public class FieldErrorExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        List<FieldErrorResponse.FieldError> errors = new ArrayList<>();

        List<ObjectError> objectErrors = ex.getAllErrors();

        for (ObjectError objectError : objectErrors) {
            FieldError fieldError = (FieldError) objectError;

            FieldErrorResponse.FieldError error = createFieldError(objectError, fieldError);

            errors.add(error);

        }


        FieldErrorResponse error = createFieldErrorResponse(status, errors);

        return ResponseEntity.status(status)
                .body(error);
    }

    private FieldErrorResponse createFieldErrorResponse(HttpStatusCode status, List<FieldErrorResponse.FieldError> errors) {
        FieldErrorResponse error = FieldErrorResponse.builder()
                .type(status.toString())
                .status(status.value())
                .message("Invalid Input")
                .errors(errors)
                .build();
        return error;
    }

    private FieldErrorResponse.FieldError createFieldError(ObjectError objectError, FieldError fieldError) {
        return FieldErrorResponse.createFieldError(
                objectError.getDefaultMessage(),
                fieldError.getRejectedValue(),
                fieldError.getField());
    }
}
