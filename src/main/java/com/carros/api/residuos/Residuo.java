package com.carros.api.residuos;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "residuos")
@Data
public class Residuo {
    @Id //define chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long id_destino;
    private String nome_destino;
    private String tipo;
    private Long year;
    private Long cidade;
    private Double quantidade;
    private String created;
    private String cor;
    private String link;
    private Long mes;






}
