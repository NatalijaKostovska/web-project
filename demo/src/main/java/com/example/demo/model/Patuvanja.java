package com.example.demo.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
@Entity
@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class Patuvanja {
    @Id
    private Long idPatuvanja;
    private String name;
    private String opis;
    @OneToMany
    private List<Grad> gradPatuvanje;
    @OneToMany
    private List<Restoran> restoranPatuvanje;
    @OneToMany
    private List<Hotel> hotelPatuvanje;
    private String ImageBase64;

}