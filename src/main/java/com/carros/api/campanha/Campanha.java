package com.carros.api.campanha;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Campanha {
    @Id //define chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long cidade;
    private Boolean ativo;
    private String nome;
    private String content;
    private String image;
    private String tipo;
    private String address;
    private Long ecoins;
    private Long pontos;
    private String cor;
    private String cor2;
    private Double latitude;
    private Double longitude;
    private String date;


}
