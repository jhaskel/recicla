package com.carros.api.logistica.logisticaResiduo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class LogisticaResiduo {
    @Id //define chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long id_tipo;
    private String nome;
    private String address;
    private String email;
    private String celular;
    private String homepage;
    private Double latitude;
    private Double longitude;
    private String content;
    private Long pontos;



}
