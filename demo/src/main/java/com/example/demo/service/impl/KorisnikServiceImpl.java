package com.example.demo.service.impl;
import com.example.demo.model.Korisnik;
import com.example.demo.model.exceptions.ExceptionHotelNotFound;
import com.example.demo.repository.KorisnikRepository;
import com.example.demo.service.KorisnikService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class KorisnikServiceImpl implements KorisnikService {

    private final KorisnikRepository korisnikRepository;

    public KorisnikServiceImpl(KorisnikRepository korisnikRepository) {
        this.korisnikRepository = korisnikRepository;
    }

    @Override
    public List<Korisnik> getAllKorisnici() {
        return this.korisnikRepository.findAll();
    }

    @Override
    public Korisnik findById(Long id) {
        return this.korisnikRepository.findById(id).orElseThrow(()->new ExceptionHotelNotFound(id));
    }

    @Override
    public Korisnik saveKorisnik(Korisnik korisnik) {
        return this.korisnikRepository.save(korisnik);
    }

    @Override
    public Korisnik updateKorisnik(Long id, Korisnik korisnik) throws IOException {
        Korisnik k = this.findById(id);
        k.setName(korisnik.getName());
        k.setLastname(korisnik.getLastname());
        return this.saveKorisnik(k);
    }

    @Override
    public void deleteById(long id) {
        this.korisnikRepository.deleteById(id);
    }
}


