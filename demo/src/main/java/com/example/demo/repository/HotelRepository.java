package com.example.demo.repository;


import com.example.demo.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface HotelRepository extends JpaRepository<Hotel,Long> {
    Optional<Hotel> findById(Long id);
    List<Hotel> findAll();
    Hotel save(Hotel hotel);
    void deleteById(long id);

}
