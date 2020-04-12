package com.example.demo.service.impl;


import com.example.demo.model.Patuvanja;
import com.example.demo.model.exceptions.ExceptionHotelNotFound;
import com.example.demo.repository.PatuvanjaRepository;
import com.example.demo.service.GradService;
import com.example.demo.service.HotelService;
import com.example.demo.service.PatuvanjaService;
import com.example.demo.service.ResoranService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Service
public class PatuvanjaServiceImpl implements PatuvanjaService {
    private final PatuvanjaRepository patuvanjaRepository;
    private final HotelService hotelService;
    private final ResoranService restoranService;
    private final GradService gradService;

    public PatuvanjaServiceImpl(PatuvanjaRepository patuvanjaRepository, HotelService hotelService, ResoranService restoranService, GradService gradService) {
        this.patuvanjaRepository = patuvanjaRepository;
        this.hotelService = hotelService;
        this.restoranService = restoranService;
        this.gradService = gradService;
    }

    @Override
    public Patuvanja saveTrip(Patuvanja patuvanja, MultipartFile image) throws IOException {
        //Hotel h = this.hotelService.findById(patuvanja.getHotelPatuvanje().getIdHotel());
        //Restoran r = this.restoranService.findById(patuvanja.getRestoranPatuvanje().getIdRestoran());
       // Grad g = this.gradService.findById(patuvanja.getGradPatuvanje().getIdGrad());
        //patuvanja.setHotelPatuvanje(h);
        //patuvanja.setGradPatuvanje(g);
       // patuvanja.setRestoranPatuvanje(r);
        if(image!=null && !image.getName().isEmpty()){
            byte[] bytes = image.getBytes();
            String base64Image = String.format("data:%s;base64,%s",image.getContentType(),
                    Base64.getEncoder().encodeToString(bytes));
            patuvanja.setImageBase64(base64Image);
        }
        return this.patuvanjaRepository.save(patuvanja);
    }

    @Override
    public List<Patuvanja> findAllTrips() {
        return this.patuvanjaRepository.findAll();
    }

    @Override
    public Patuvanja findById(Long id) {
        return this.patuvanjaRepository.findById(id).orElseThrow(()->new ExceptionHotelNotFound(id));
    }

    @Override
    public Patuvanja updatePatuvanje(Long id, Patuvanja patuvanja, MultipartFile image) throws IOException {
        Patuvanja p = this.findById(id);
        //Hotel h = this.hotelService.findById(patuvanja.getHotelPatuvanje().getIdHotel());
        //Restoran r = this.restoranService.findById(patuvanja.getRestoranPatuvanje().getIdRestoran());
        //Grad g = this.gradService.findById(patuvanja.getGradPatuvanje().getIdGrad());
        p.setName(patuvanja.getName());
        p.setOpis(patuvanja.getOpis());
        //p.setGradPatuvanje(g);
       // p.setHotelPatuvanje(h);
        //p.setRestoranPatuvanje(r);
        if(image!=null && !image.getName().isEmpty()){
            byte[] bytes = image.getBytes();
            String base64Image = String.format("data:%s;base64,%s",image.getContentType(),
                    Base64.getEncoder().encodeToString(bytes));
            p.setImageBase64(base64Image);
        }
        return this.patuvanjaRepository.save(p);
    }

    @Override
    public void deleteById(long id) {
        this.patuvanjaRepository.deleteById(id);
    }
}
