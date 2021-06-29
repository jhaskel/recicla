package com.carros.api.coletando;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Coletando {
    @Id //define chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long cidade;
    private String dia;
    private Long idcaminhao;
    private Boolean ativo;
    private Long idrota;
    private Double latitude;
    private Double longitude;
    private String hora;
    private Long Usuario;
    private Double quant;







}
