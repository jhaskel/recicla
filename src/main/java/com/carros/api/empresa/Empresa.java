package com.carros.api.empresa;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Empresa {
    @Id //define chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long cidade;
    private String nome;
    private String image;
    private Double latitude;
    private Double longitude;
    private String endereco;
    private String bairro;
    private String nomecidade;
    private String telefone;
    private String celular;
    private String contato;
    private String cnpj;
    private String cep;
    private String teste;





}
