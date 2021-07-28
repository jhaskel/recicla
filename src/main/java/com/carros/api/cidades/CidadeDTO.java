package com.carros.api.cidades;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class CidadeDTO {
    private Long id;
    private String nome;
    private String img;
    private double latitude;
    private double longitude;
    private double gasto_anual;
    private Long habitantes;
    private String icone;
    private String imagem;
    private Long ativo;
    private Long cidade;
    private Long regiao;


    public static CidadeDTO create(Cidade classe) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(classe, CidadeDTO.class);
    }

}
