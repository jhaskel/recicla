package com.carros.api.rotas.rotadias;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data

public class RotadiasDTO {
    private Long id;
    private Long rota;
    private Boolean ativo;
    private Long dia;
    private String inicio;
    private String fim;
    private String nomedia;
    private String nomerota;
    private String nometipo;
    private String nomeperiodo;
    private String nomebairro;



    public static RotadiasDTO create(Rotadias dica) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(dica, RotadiasDTO.class);
    }



}
