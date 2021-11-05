package com.carros.api.parceiro;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Data
@Entity
public class Parceiro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long iduser;
    private String nome;
    private String email;
    private String address;
    private Boolean ativo;
    private Boolean isloja;
    private String celular;
    private Long cidade;
    private String content;
    private String created;
    private String image;
    private String image2;
    private Double latitude;
    private Double longitude;
    private String slogan;
    private String tipo;
}

