package com.geekshirt.orderservice.handler;

import com.geekshirt.orderservice.exceptions.AccountNotFoundException;
import com.geekshirt.orderservice.exceptions.IncorrectOrderRequestException;
import com.geekshirt.orderservice.exceptions.OrderServiceExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
@RestController
public class OrderServiceExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handlerAllExceptions(Exception exception, WebRequest request){

        OrderServiceExceptionResponse response = new OrderServiceExceptionResponse(exception.getMessage(),
                request.getDescription(false),
                HttpStatus.INTERNAL_SERVER_ERROR,
                LocalDateTime.now());

        return new ResponseEntity<>(response, response.getStatus());
    }



    @ExceptionHandler(IncorrectOrderRequestException.class)
    public ResponseEntity<Object> handleIncorrectRequest(Exception exception, WebRequest request){

        OrderServiceExceptionResponse response = new OrderServiceExceptionResponse(exception.getMessage(),
                request.getDescription(false),
                HttpStatus.BAD_REQUEST, LocalDateTime.now());

        return new ResponseEntity<>(response, response.getStatus());
    }


    @ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity<Object> handleAccountNotFound(Exception exception, WebRequest request){

        OrderServiceExceptionResponse response = new OrderServiceExceptionResponse(exception.getMessage(),
                request.getDescription(false),
                HttpStatus.NOT_FOUND, LocalDateTime.now());

        return new ResponseEntity<>(response, response.getStatus());
    }
}
