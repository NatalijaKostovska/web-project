package com.example.demo.service.impl;


import com.example.demo.model.Restoran;
import com.example.demo.model.exceptions.ExceptionHotelNotFound;
import com.example.demo.repository.RestoranRepository;
import com.example.demo.service.ResoranService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class RestoranServiceImpl implements ResoranService {
    private final RestoranRepository restoranRepository;

    public RestoranServiceImpl(RestoranRepository restoranRepository) {
        this.restoranRepository = restoranRepository;
    }

    @Override
    public List<Restoran> getAllRestorani() {
        return this.restoranRepository.findAll();
    }

    @Override
    public Restoran findById(Long id) {
        return this.restoranRepository.findById(id).orElseThrow(()->new ExceptionHotelNotFound(id));
    }


    @Override
    public Restoran saveRestoran(Restoran restoran) {
        return this.restoranRepository.save(restoran);
    }

    @Override
    public Restoran updateRestoran(Long id, Restoran restoran) throws IOException {
        Restoran r = this.findById(id);
        r.setName(restoran.getName());
        r.setOpis(restoran.getOpis());
        r.setStars(restoran.getStars());
        return this.saveRestoran(r);

    }

    @Override
    public void deleteById(long id) {
        this.restoranRepository.findById(id);
    }
}
