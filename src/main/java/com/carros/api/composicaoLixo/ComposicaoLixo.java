package com.carros.api.composicaoLixo;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class ComposicaoLixo {
    @Id //define chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String aviso;
    private boolean aviso1;
    private boolean aviso2;
    private String avisos;
    private String content;
    private String contentNo;
    private String image;
    private String title;



}
