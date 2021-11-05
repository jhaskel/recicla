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

    private Long id;
    private Boolean ativo;
    private Boolean is_loja;
    private Long cidade;
    private String nome;
    private String content;
    private String  slogan;
    private String address;
    private Double latitude;
    private Double longitude;
    private String image;
    private String image2;
    private String cor;
    private String email;
    private String homepage;
    private String celular;
    private String telefone;
    private String date;
    private String tipo;

}

