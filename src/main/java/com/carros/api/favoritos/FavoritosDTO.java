package com.carros.api.favoritos;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data

public class FavoritosDTO {
    private Long id;
    private Long usuario;
    private Boolean ativo;
    private String tipo;
    private Long idevento;
    private String created;


    public static FavoritosDTO create(Favoritos dica) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(dica, FavoritosDTO.class);
    }



}
