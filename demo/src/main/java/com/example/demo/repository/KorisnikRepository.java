package com.example.demo.repository;

import com.example.demo.model.Hotel;
import com.example.demo.model.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface KorisnikRepository extends JpaRepository<Korisnik,Long> {
    List<Korisnik> findAll();
    Optional<Korisnik> findById(Long id);
    Korisnik save(Korisnik korisnik);
    void deleteById(long id);


}
