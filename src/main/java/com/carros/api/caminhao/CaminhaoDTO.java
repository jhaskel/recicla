package com.carros.api.caminhao;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data

public class CaminhaoDTO {
    private Long id;
    private Long ano;
    private String coleta;
    private Boolean coletando;
    private String icone;
    private Long idempresa;
    private Double latitude;
    private Double longitude;
    private String marca;
    private String modelo;
    private String motorista;
    private String placa;

    public static CaminhaoDTO create(Caminhao dica) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(dica, CaminhaoDTO.class);
    }



}
