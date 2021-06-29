package com.carros.api.apoiadoresAnuncio;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class ApoiadoresAnuncio {
    @Id //define chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long apoiador;
    private Long regiao;
    private Long visualizacao;
    private Long aplicativo;
    private Boolean ativo;
    private Boolean somentecidade;
    private Long cidade;
    private String created;
    private String validade;
    private String nome;//vem da consulta join
    private String logo;//vem da consulta join
    private String site;//vem da consulta join
    private String lema;//vem da consulta join







}
