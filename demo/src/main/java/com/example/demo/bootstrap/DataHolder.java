package com.example.demo.bootstrap;

import com.example.demo.model.*;
import com.example.demo.repository.jpa.jpaKorisnikRepository;
import lombok.Getter;
import org.springframework.stereotype.Component;
import com.example.demo.repository.jpa.*;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class DataHolder {

    public static final List<Korisnik> korisnici = new ArrayList<>();
    public static final List<Patuvanja> trips = new ArrayList<>();
    public static final List<Restoran> restorani = new ArrayList<>();
    public static final List<Hotel> hoteli = new ArrayList<>();
    public static final List<Grad> gradovi = new ArrayList<>();


    public final com.example.demo.repository.jpa.jpaKorisnikRepository jpaKorisnikRepository;
    public final jpaPatuvanjaRepository jpaPatuvanjaRepository;
    public final jpaResoranRepository jpaResoranRepository;
    public final jpaGradRepository jpaGradRepository;
    public final jpaHotelRepository jpaHotelRepository;

    public DataHolder(jpaKorisnikRepository jpaKorisnikRepository, jpaPatuvanjaRepository jpaPatuvanjaRepository, jpaResoranRepository jpaResoranRepository,  jpaGradRepository jpaGradRepository, jpaHotelRepository jpaHotelRepository) {
        this.jpaKorisnikRepository = jpaKorisnikRepository;
        this.jpaPatuvanjaRepository = jpaPatuvanjaRepository;
        this.jpaResoranRepository = jpaResoranRepository;

        this.jpaGradRepository = jpaGradRepository;
        this.jpaHotelRepository = jpaHotelRepository;
    }
    @PostConstruct
    public void init() {
        trips.add(new Patuvanja(1L,"Canyon matka","dhsdsdjfds",new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),"as"));
        korisnici.add(new Korisnik(1L,"Petko", "Petkovski",new ArrayList<>()));
        restorani.add(new Restoran(1L,"Skopski Merak",5,"dasdsadasdsa"));
        hoteli.add(new Hotel(1L,"Molika",4));
        gradovi.add(new Grad(4L,"Velkes"));

    }
}
