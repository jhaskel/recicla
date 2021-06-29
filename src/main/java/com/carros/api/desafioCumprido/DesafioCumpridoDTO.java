package com.carros.api.desafioCumprido;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data

public class DesafioCumpridoDTO {
    private Long id;
    private Long desafio;
    private Long usuario;
    private Boolean status;
    private String created;
    private Boolean ativo;
    private Double quant;



    public static DesafioCumpridoDTO create(DesafioCumprido dica) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(dica, DesafioCumpridoDTO.class);
    }



}
