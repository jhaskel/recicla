package com.carros.api.cupomMeus;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Data
@Entity
public class CupomMeus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long usuario;
    private Long cidade;
    private Boolean ativo;
    private Long ecoins;
    private Long pontos;
    private Long qtde;
    private Long idloja;
    private String tipo;
    private String tipocupom;
    private String titulo;
    private String observacao;
    private String produtos;
    private String horario;
    private String date;
    private String nomeloja;
    private String nomeusuario;
    private String codigo;
    private String qrcode;
    private String imagem;
    private Long valor;
    private Boolean isonline;
    private String created;
    private String modified;

}

