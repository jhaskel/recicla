package com.carros.api.bairro;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Bairro {
    @Id //define chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long cidade;
    private String nome;







}
