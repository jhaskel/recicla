package com.carros.api.ruas;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class RuaDTO {
    private Long id;
    private String nome;
    private Long bairro;
    private Long cidade;
    private String cep;


    public static RuaDTO create(Rua rua) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(rua, RuaDTO.class);
    }

}
