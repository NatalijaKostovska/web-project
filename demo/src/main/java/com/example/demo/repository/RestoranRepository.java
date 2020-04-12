package com.example.demo.repository;


import com.example.demo.model.Restoran;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface RestoranRepository extends JpaRepository<Restoran,Long> {
    Optional<Restoran> findById(Long id);
    List<Restoran> findAll();
    Restoran save(Restoran restoran);
    void deleteById(long id);

}

