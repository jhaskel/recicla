package com.carros.api.usuario;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Data
@Entity(name = "user")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String login;
    private String nome;
    private String senha;
    private String urlFoto;
    private Long cidade;
    private Long bairro;
    private Long rua;
    private String celular;
    private String nascimento;
    private String genero;
    private Long distancia ;
    private String local;
    private Double latitude;
    private Double longitude;
    private String tipo;
    private Long empresa;
    private String address;
    private Boolean ativo;
    private Long regiao;
    private String logadoem;



}

