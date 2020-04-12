package com.example.demo.service;


import com.example.demo.model.Grad;

import java.io.IOException;
import java.util.List;

public interface GradService {
    Grad findById(Long id);
    List<Grad> findAll();
    Grad save(Grad grad);
    void deleteById(Long id);
    Grad updateProduct(Long id, Grad grad) throws IOException;

}
