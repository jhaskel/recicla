package com.carros.api.trajeto;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data

public class TrajetoDTO {
    private Long id;
    private Long idrota;
    private Long usuario;
    private Long idempresa;
    private Double latitude;
    private Double longitude;
    private String rua;
    private String bairro;
    private String cep;
    private Double altitude;
    private String dia;
    private String hora;
    private String created;

    public static TrajetoDTO create(Trajeto dica) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(dica, TrajetoDTO.class);
    }



}
