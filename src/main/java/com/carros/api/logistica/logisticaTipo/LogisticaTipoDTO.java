package com.carros.api.logistica.logisticaTipo;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data

public class LogisticaTipoDTO {
    private Long id;
    private String nome;
    private Long pontos;

    private String content;private Long cormapa;
    private String corhexa;
    private String icone;


    public static LogisticaTipoDTO create(LogisticaTipo logistica) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(logistica, LogisticaTipoDTO.class);
    }



}
