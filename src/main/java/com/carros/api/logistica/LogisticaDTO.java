package com.carros.api.logistica;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data

public class LogisticaDTO {
    private Long id;
    private Long idloja;
    private Long cidade;
    private Boolean ativo;

    private String nome;
    private String content;
    private String image;
    private String tipo;
    private String address;
    private Long ecoins;
    private Long pontos;
    private String qrcode;
    private Double latitude;
    private Double longitude;
    private String date;
    private Boolean retirar;
    private String email;
    private String celular;
    private String homepage;




    public static LogisticaDTO create(Logistica logistica) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(logistica, LogisticaDTO.class);
    }



}
