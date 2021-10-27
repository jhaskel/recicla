package com.carros.api.coletando.coletacrud;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "coletando")
@Data
public class Coletacrud {
    @Id //define chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long cidade;
    private String dia;
    private Long idcaminhao;
    private Boolean ativo;
    private Long idrota;
    private Double latitude;
    private Double longitude;
    private String hora;
    private Long Usuario;
    private Long peso;
    private String status;
    private String created;
    private String nomerota;//deletar campo no banco
    private String nomeempresa;//deletar campo no banco
    private String tiporota;//deletar campo no banco







}
