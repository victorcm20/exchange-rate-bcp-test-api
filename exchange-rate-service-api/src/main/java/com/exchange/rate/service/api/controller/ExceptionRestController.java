package com.exchange.rate.service.api.controller;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.exchange.rate.service.api.model.enums.ErrorCode;
import com.exchange.rate.service.api.model.response.BaseWebResponse;

@RestControllerAdvice
public class ExceptionRestController {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<BaseWebResponse> handleEntityNotFoundException(EntityNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(BaseWebResponse.error(ErrorCode.ENTITY_NOT_FOUND, ex.getMessage()));
    }
}
