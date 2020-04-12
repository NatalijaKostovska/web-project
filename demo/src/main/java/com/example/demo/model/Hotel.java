package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class Hotel {
    @Id
    private Long idHotel;
    private String HotelName;
    private Integer numberOfStars;

}
