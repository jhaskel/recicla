package com.carros.api.rotas.rotadias;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Rotadias {
    @Id //define chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long rota;
    private Boolean ativo;
    private Long dia;
    private String inicio;
    private String fim;
    private String nomedia;
    private String nomerota;
    private String nometipo;
    private String nomeperiodo;
    private String nomebairro;






}
