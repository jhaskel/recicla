package com.carros.api.rotaDiaria;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class RotaDiaria {
    @Id //define chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idcoleta;
    private Long idrota;
    private Long usuario;
    private Long idempresa;
    private Long idcaminhao;
    private Double latitude;
    private Double longitude;
    private String hora;
    private String dia;
    private Long semana;
    private Long ano;
    private Long mes;


}
