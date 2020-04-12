package com.example.demo.service;

import com.example.demo.model.Restoran;

import java.io.IOException;
import java.util.List;

public interface ResoranService {
    List<Restoran> getAllRestorani();
    Restoran findById(Long id);
    Restoran saveRestoran(Restoran restoran);
    Restoran updateRestoran(Long id, Restoran restoran) throws IOException;
    void deleteById(long id);
}
