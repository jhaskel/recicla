package com.carros.api.pontuacao;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@Data
@Entity
public class Pontuacao {

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
    private Long total;
    private Long cidade;
    private String nome;


}

