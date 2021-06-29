package com.carros.api.rotaDiaria;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data

public class RotaDiariaDTO {
    private Long id;
    private Long idcoleta;
    private Long idrota;
    private Long usuario;
    private Long idempresa;
    private Long idcaminhao;
    private Double latitude;
    private Double longitude;
    private String hora;
    private String dia;
    private Long semana;
    private Long ano;
    private Long mes;


    public static RotaDiariaDTO create(RotaDiaria dica) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(dica, RotaDiariaDTO.class);
    }



}
