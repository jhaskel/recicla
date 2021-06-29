package com.carros.api.pontua;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class PontuaDTO {
    private Long id;
    private Long usuario;
    private Long pontos;
    private Long ecoins;
    private Long ano;
    private Long mes;
    private Long semana;
    private String hoje;
    private String extrato;
    private Long icone;
    private Long cidade;



    public static PontuaDTO create(Pontua pontuacao) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(pontuacao, PontuaDTO.class);
    }
}
