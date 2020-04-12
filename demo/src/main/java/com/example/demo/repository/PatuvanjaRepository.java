package com.example.demo.repository;


import com.example.demo.model.Hotel;
import com.example.demo.model.Patuvanja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface PatuvanjaRepository extends JpaRepository<Patuvanja,Long> {
    Patuvanja save(Patuvanja patuvanja);
    List<Patuvanja> findAll();
    Optional<Patuvanja> findById(Long id);
    void deleteById(long id);

}