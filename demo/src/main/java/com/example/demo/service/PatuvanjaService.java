package com.example.demo.service;


import com.example.demo.model.Patuvanja;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface PatuvanjaService {
    Patuvanja saveTrip(Patuvanja patuvanja, MultipartFile image)throws IOException;
    List<Patuvanja> findAllTrips();
    Patuvanja findById(Long id);
    Patuvanja updatePatuvanje(Long id, Patuvanja patuvanja, MultipartFile image) throws IOException;
    void deleteById(long id);
}
