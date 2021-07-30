package com.carros.api.qrcode;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Data
@Entity
public class Qrcode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String qrcode;
    private Long cidade;
    private String tipo;
    private String tipotipo;
    private String codigo;
    private Long idloja;
    private Long valor;
    private Boolean ativo;

}

