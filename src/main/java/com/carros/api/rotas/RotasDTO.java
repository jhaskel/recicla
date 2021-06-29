package com.carros.api.rotas;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data

public class RotasDTO {
    private Long id;
    private Boolean ativo;
    private Long cidade;
    private String nome;
    private String periodo;
    private String local;
    private String tipo;


    public static RotasDTO create(Rotas dica) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(dica, RotasDTO.class);
    }



}
