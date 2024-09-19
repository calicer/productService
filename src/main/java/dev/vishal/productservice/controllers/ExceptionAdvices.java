package dev.vishal.productservice.controllers;


import dev.vishal.productservice.dtos.ErrorResponseDto;
import dev.vishal.productservice.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


/*
controller advice is type of global method declaration,
any controller if came with any exception can access the method
 */
@ControllerAdvice
public class ExceptionAdvices {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponseDto> notFoundException(NotFoundException exception) {
        ErrorResponseDto errorResponseDto = new ErrorResponseDto();
        errorResponseDto.setMessage(exception.getMessage());
        errorResponseDto.setCode(404);
        errorResponseDto.setDetails("Sorry I am not found");

        ResponseEntity<ErrorResponseDto> responseEntity = new ResponseEntity<>(errorResponseDto, HttpStatus.NOT_FOUND);
        return responseEntity;
    }
}
