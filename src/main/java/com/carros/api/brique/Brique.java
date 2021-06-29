package com.carros.api.brique;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Brique {
    @Id //define chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean ativo;
    private Long categoria;
    private String nomecategoria;
    private Long cidade;
    private Long user;
    private String nome;
    private Long visualizado;
    private Long recompensa;
    private String title;
    private String content;
    private String created;
    private String image;
    private String celular;
    private String zap;
    private String cod;
    private Long bricado;
    private Long disponibilidade;
    private String databrique;







}
