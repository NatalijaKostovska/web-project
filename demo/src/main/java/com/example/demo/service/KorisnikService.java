package com.example.demo.service;


import com.example.demo.model.Korisnik;

import java.io.IOException;
import java.util.List;

public interface KorisnikService {
    List<Korisnik> getAllKorisnici();
    Korisnik findById(Long id);
    Korisnik saveKorisnik(Korisnik korisnik);
    Korisnik updateKorisnik(Long id, Korisnik korisnik) throws IOException;
    void deleteById(long id);
}
