package com.lgt.lgtservice.exceptions;

import com.lgt.lgtservice.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class VehiculeExceptionHandler {
    @ExceptionHandler(VehiculeNotFoundException.class)
    public ResponseEntity<ErrorResponse> handlerVehiculeNotFoundException(VehiculeNotFoundException vex) {
        ErrorResponse response = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                vex.getMessage()
        );
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

    }
}
