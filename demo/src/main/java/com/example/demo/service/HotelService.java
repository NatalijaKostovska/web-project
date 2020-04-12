package com.example.demo.service;

import com.example.demo.model.Hotel;

import java.io.IOException;
import java.util.List;

public interface HotelService {
    List<Hotel> findAllHotels();
    Hotel findById(Long id);
    //Hotel saveHotel(Long id, String HotelName, Integer numberOfStars, Grad gradHotel);
    Hotel saveHotel(Hotel hotel);
    Hotel updateHotel(Long id, Hotel hotel) throws IOException;
    void deleteById(Long id);

}
