package com.carros.api.rotas.rotabairros;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data

public class RotabairrosDTO {
    private Long id;
    private Long rota;
    private Long bairro;
    private Boolean ativo;

    public static RotabairrosDTO create(Rotabairros dica) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(dica, RotabairrosDTO.class);
    }



}
