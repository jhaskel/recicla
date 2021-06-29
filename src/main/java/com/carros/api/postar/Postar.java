package com.carros.api.postar;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Postar {
    @Id //define chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean ativo;
    private Long usuario;
    private Long cidade;
    private String descricao;
    private Long comentario;
    private Long likes;
    private String image;
    private String date;
    private String created;
    private String donopost;
    private String donofoto;









}
