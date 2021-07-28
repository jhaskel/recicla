package com.carros.api.cidades;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class CidadeDTO {
    private Long id;
    private String nome;
    private Double latitude;
    private Double longitude;
    private Double gasto_anual;
    private Double lixo;
    private Double recicldo;
    private Long habitantes;
    private Long codigo;
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
