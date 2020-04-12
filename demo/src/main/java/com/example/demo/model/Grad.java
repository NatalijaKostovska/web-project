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
public class Grad {
    @Id
    private Long idGrad;
    private String GradIme;

}
