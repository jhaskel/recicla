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
    private Long ecoins;
    private Long pontos;
    private String cor;
    private String cor2;
    private Double latitude;
    private Double longitude;
    private String date;




    public static CampanhaDTO create(Campanha logistica) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(logistica, CampanhaDTO.class);
    }



}
