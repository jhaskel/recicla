package com.carros.api.trajeto;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Trajeto {
    @Id //define chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idrota;
    private Long usuario;
    private Long idempresa;
    private Double latitude;
    private Double longitude;
    private String rua;
    private String bairro;
    private String cep;
    private Double altitude;
    private String dia;
    private String hora;
    private String created;


}
