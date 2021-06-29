package com.carros.api.apoiadoresAnuncio;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class ApoiadoresAnuncioDTO {
    private Long id;
    private Long apoiador;
    private Long regiao;
    private Long visualizacao;
    private Long aplicativo;
    private Boolean ativo;
    private Boolean somentecidade;
    private Long cidade;
    private String created;
    private String validade;
    private String nome;//vem da consulta join
    private String logo;//vem da consulta join
    private String site;//vem da consulta join
    private String lema;//vem da consulta join


    public static ApoiadoresAnuncioDTO create(ApoiadoresAnuncio bairro) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(bairro, ApoiadoresAnuncioDTO.class);
    }

}
