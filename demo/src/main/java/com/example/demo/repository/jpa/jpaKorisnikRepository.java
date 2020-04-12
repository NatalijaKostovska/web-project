package com.example.demo.repository.jpa;

import com.example.demo.model.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;
public interface jpaKorisnikRepository extends JpaRepository<Korisnik,String> {
}
