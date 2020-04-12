package com.example.demo.service.impl;


import com.example.demo.model.Hotel;
import com.example.demo.model.exceptions.ExceptionHotelNotFound;
import com.example.demo.repository.HotelRepository;
import com.example.demo.service.GradService;
import com.example.demo.service.HotelService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {
    private final HotelRepository hotelRepository;
    private final GradService gradService;

    public HotelServiceImpl(HotelRepository hotelRepository, GradService gradService) {
        this.hotelRepository = hotelRepository;
        this.gradService = gradService;
    }

    @Override
    public List<Hotel> findAllHotels() {
        return this.hotelRepository.findAll();
    }

    @Override
    public Hotel findById(Long id) {
        return this.hotelRepository.findById(id).orElseThrow(()->new ExceptionHotelNotFound(id));
    }

    @Override
    public Hotel saveHotel(Hotel hotel) {
       // Grad grad = this.gradService.findById(hotel.getGradHotel().getIdGrad());
       // hotel.setGradHotel(grad);
        return this.hotelRepository.save(hotel);
    }

    @Override
    public Hotel updateHotel(Long id, Hotel hotel) throws IOException {
        Hotel h = this.findById(id);
        h.setHotelName(hotel.getHotelName());
      //  h.setGradHotel(hotel.getGradHotel());
        h.setNumberOfStars(hotel.getNumberOfStars());
        return this.saveHotel(h);
    }


    @Override
    public void deleteById(Long id) {
        this.hotelRepository.deleteById(id);
    }
}
