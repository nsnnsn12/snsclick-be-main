package com.snsclicksystem.main.adapter.in.common;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionAdvice {
    @ExceptionHandler({NoSearchException.class})
    public ResponseEntity<ApiExceptionEntity> exceptionHandler(HttpServletRequest httpServletRequest, final NoSearchException e){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ApiExceptionEntity.builder().errorCode("100").errorMessage(e.getMessage()).build());
    }
    
    @ExceptionHandler({NoCreateException.class})
    public ResponseEntity<ApiExceptionEntity> createExceptionHandler(HttpServletRequest httpServletRequest, final NoCreateException e){
        return ResponseEntity
                .status(HttpStatus.EXPECTATION_FAILED)
                .body(ApiExceptionEntity.builder().errorCode("409").errorMessage(e.getMessage()).build());
    }
}
