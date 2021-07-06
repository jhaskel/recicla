package com.carros.api.pontua;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@Data
@Entity(name = "pontuacao")
public class Pontua {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long usuario;
    private Long pontos;
    private Long ecoins;
    private Long ano;
    private Long mes;
    private Long semana;
    private String hoje;
    private String extrato;
    private String tipo;
    private Long cidade;




}

