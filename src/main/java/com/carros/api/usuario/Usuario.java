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
    private String nome;
    private String login;
    private String senha;
    private String email;
    private String urlFoto;
    private Long cidade;
    private Long bairro;
    private Long rua;
    private String celular;
    private String nascimento;
    private String genero;
    private String local;
    private Long distancia;
    private Double latitude;
    private Double longitude;
    private String tipo;
    private Long empresa;
    private String address;
    private Long quantdicas;
    private Long quantnoticias;
    private Boolean ativo;
    private Long regiao;
    private String logadoem;



}

