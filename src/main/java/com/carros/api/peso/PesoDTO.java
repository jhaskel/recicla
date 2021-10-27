package com.carros.api.peso;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data

public class PesoDTO {
    private Long id;
    private Long idrota;
    private Long tara;
    private Long bruto;

    public static PesoDTO create(Peso dica) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(dica, PesoDTO.class);
    }



}
