package com.carros.api.brique.briqueCategoria;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data

public class BriquecategoriaDTO {
    private Long id;
    private String title;
    private Long recompensa;

    public static BriquecategoriaDTO create(Briquecategoria briquecategoria) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(briquecategoria, BriquecategoriaDTO.class);
    }



}
