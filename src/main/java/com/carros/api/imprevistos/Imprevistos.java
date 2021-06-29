package com.carros.api.imprevistos;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Imprevistos {
    @Id //define chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long coleta;
    private Long rota;
    private Long cidade;
    private Long ano;
    private Long usuario;
    private Long empresa;
    private Long caminhao;
    private String dia;
    private String content;
    private String hora;
    private Boolean parado;


}
