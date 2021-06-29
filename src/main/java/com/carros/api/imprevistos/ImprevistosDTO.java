package com.carros.api.imprevistos;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data

public class ImprevistosDTO {
    private Long id;
    private Long coleta;
    private Long rota;
    private Long cidade;
    private Long ano;
    private Long usuario;
    private Long empresa;
    private Long caminhao;
    private String dia;
    private String content;
    private String hora;
    private Boolean parado;

    public static ImprevistosDTO create(Imprevistos dica) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(dica, ImprevistosDTO.class);
    }



}
