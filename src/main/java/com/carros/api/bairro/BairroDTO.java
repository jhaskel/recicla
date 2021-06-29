package com.carros.api.bairro;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class BairroDTO {
    private Long id;
    private Long cidade;
    private String nome;


    public static BairroDTO create(Bairro bairro) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(bairro, BairroDTO.class);
    }

}
