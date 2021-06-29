package com.carros.api.noticias;

import com.google.api.client.util.DateTime;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Noticias {
    @Id //define chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long cidade;
    private String title;
    private String content;
    private String image;
    private String created;
    private Boolean ativo;
    private String video;
    private Double quant;
    private String tipo;
    private String credito_midia;
    private String credito_nome;
    private String credito_titulo;
    private String credito_profissao;
    private String link;






}
