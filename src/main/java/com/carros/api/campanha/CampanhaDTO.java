package com.carros.api.campanha;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data

public class CampanhaDTO {
    private Long id;
    private Long cidade;
    private Boolean ativo;
    private String nome;
    private String content;
    private String image;
    private String tipo;
    private String address;
    private String title;
    private Long ecoins;
    private Long pontos;




    public static CampanhaDTO create(Campanha logistica) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(logistica, CampanhaDTO.class);
    }



}
