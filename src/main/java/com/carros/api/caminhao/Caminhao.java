package com.carros.api.caminhao;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Caminhao {
    @Id //define chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long ano;
    private String coleta;
    private Boolean coletando;
    private String icone;
    private Long idempresa;
    private Double latitude;
    private Double longitude;
    private String marca;
    private String modelo;
    private String motorista;
    private Long idmotorista;
    private String placa;

}
