package com.carros.api.logistica.logisticaResiduo;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data

public class LogisticaResiduoDTO {
    private Long id;
    private Long id_tipo;
    private String nome;
    private String address;
    private String email;
    private String celular;
    private String homepage;
    private Double latitude;
    private Double longitude;
    private String content;
    private Long pontos;

    public static LogisticaResiduoDTO create(LogisticaResiduo logistica) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(logistica, LogisticaResiduoDTO.class);
    }



}
