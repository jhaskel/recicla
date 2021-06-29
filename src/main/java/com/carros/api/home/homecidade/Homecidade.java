package com.carros.api.home.homecidade;

import com.carros.api.home.Home;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Homecidade {
    @Id //define chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long home;
    private Long cidade;
    private Boolean ativo;
    private Long posicao;
    private String titulo;//deletar do banco
    private String icone;//deletar do banco




}
