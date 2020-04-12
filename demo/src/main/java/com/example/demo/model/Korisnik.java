package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
@Entity
@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class Korisnik {
    @Id
    private Long idKorisnik;
    private String name;
    private String lastname;
    @OneToMany
    private List<Patuvanja> patuvanje;
}
