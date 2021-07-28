package com.carros.api.cidades;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "cidades")
@Data
public class Cidade {
    @Id //define chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Double latitude;
    private Double longitude;
    private Double gasto_anual;
    private Double lixo;
    private Double reciclado;
    private Long habitantes;
    private Long codigo;
    private String icone;
    private String imagem;
    private Long ativo;
    private Long cidade;
    private Long regiao;










}
