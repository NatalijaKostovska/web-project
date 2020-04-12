package com.example.demo.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class KorisnikNotFoundException extends RuntimeException {
    public KorisnikNotFoundException(Long id) {
        super(String.format("Korisnik with id %d is not found!", id));
    }
}

