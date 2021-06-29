package com.carros.api.rotasUser;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data

public class RotasUserDTO {
    private Long id;
    private Long user;
    private Long rota;
    private String nomerota;
    private String tiporota;


    public static RotasUserDTO create(RotasUser dica) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(dica, RotasUserDTO.class);
    }



}
