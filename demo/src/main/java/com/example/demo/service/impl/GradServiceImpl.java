package com.example.demo.service.impl;

import com.example.demo.model.Grad;
import com.example.demo.model.exceptions.ExceptionGradNotFound;
import com.example.demo.repository.GradRepository;
import com.example.demo.service.GradService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class GradServiceImpl implements GradService {
    private final GradRepository gradRepository;

    public GradServiceImpl(GradRepository gradRepository) {
        this.gradRepository = gradRepository;
    }


    @Override
    public Grad findById(Long id) {
        return this.gradRepository.findById(id).orElseThrow(()->new ExceptionGradNotFound(id));
    }

    @Override
    public List<Grad> findAll() {
        return this.gradRepository.findAll();
    }

    @Override
    public Grad save(Grad grad) {
        return this.gradRepository.save(grad);
    }

    @Override
    public void deleteById(Long id) {
        this.gradRepository.deleteById(id);
    }

    @Override
    public Grad updateProduct(Long id, Grad grad) throws IOException {
        Grad g = this.findById(id);
        grad.setGradIme(grad.getGradIme());
        return this.gradRepository.save(g);
    }
}
