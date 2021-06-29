package com.carros.api.logistica.logisticaTipo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class LogisticaTipo {
    @Id //define chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Long pontos;
    private Long cormapa;
    private String corhexa;
    private String icone;
    private String content;


}
