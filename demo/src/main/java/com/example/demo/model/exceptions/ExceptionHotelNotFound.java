package com.example.demo.model.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ExceptionHotelNotFound extends RuntimeException {
    public ExceptionHotelNotFound(Long id) {
        super(String.format("Korisnik with id %d is not found!", id));
    }
}