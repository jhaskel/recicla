package com.carros.api.ecopontos;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Ecopontos {
    @Id //define chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long cidade;
    private String cor;
    private String tipo;
    private String title;
    private String subtitle;
    private String pode;
    private String nopode;


}
