package com.carros.api.desafioCumprido;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class DesafioCumprido {
    @Id //define chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long desafio;
    private Long usuario;
    private Boolean status;
    private String created;
    private Boolean ativo;
    private Double quant;
}
