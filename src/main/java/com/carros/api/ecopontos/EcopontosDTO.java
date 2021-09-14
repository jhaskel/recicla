package com.carros.api.ecopontos;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data

public class EcopontosDTO {
    private Long id;
    private Long cidade;
    private String cor;
    private String tipo;
    private String title;
    private String subtitle;
    private String pode;
    private String nopode;

    public static EcopontosDTO create(Ecopontos ecopontos) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(ecopontos, EcopontosDTO.class);
    }



}
