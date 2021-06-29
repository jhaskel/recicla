package com.carros.api.desafios;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@Data
@Entity
public class Desafio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long cidade;
    private String nome;
    private String tipo;
    private Long tiposub;
    private String descricao;
    private String urlFoto;
    private String urlVideo;
    private Long quantidade;
    private Long pontuacao;
    private Boolean ativo;
    private String created;
    private String validade;

}

