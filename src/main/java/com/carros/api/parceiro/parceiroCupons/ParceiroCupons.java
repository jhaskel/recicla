package com.carros.api.parceiro.parceiroCupons;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Data
@Entity
public class ParceiroCupons {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean ativo;
    private Boolean isonline;
    private Long idloja;
    private String titulo;
    private String patrocinador;
    private String observacao;
    private Long desconto;
    private String horario;
    private String produtos;
    private Long quantidade;
    private Long estoque;
    private String tipo;
    private String tipocupom;
    private Long valor;
    private String imagem;
    private String created;
    private Long cidade;


}

