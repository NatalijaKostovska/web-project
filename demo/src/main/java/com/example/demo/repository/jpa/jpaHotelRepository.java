package com.example.demo.repository.jpa;


import com.example.demo.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface jpaHotelRepository extends JpaRepository<Hotel,String> {
}
