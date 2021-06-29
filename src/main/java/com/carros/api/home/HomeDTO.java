package com.carros.api.home;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data

public class HomeDTO {
    private Long id;
    private String title;
    private String image;
    private String link;
    private Boolean ativo;


    public static HomeDTO create(Home dica) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(dica, HomeDTO.class);
    }



}
