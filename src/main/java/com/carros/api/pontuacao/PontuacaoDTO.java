package com.carros.api.pontuacao;

import lombok.Data;
import org.joda.time.DateTime;
import org.modelmapper.ModelMapper;

@Data
public class PontuacaoDTO {
    private Long id;
    private Long usuario;
    private Long pontos;
    private Long ecoins;
    private Long ano;
    private Long mes;
    private Long semana;
    private Long cidade;
    private String hoje;
    private String extrato;
    private Long total;
    private String nome;


    public static PontuacaoDTO create(Pontuacao pontuacao) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(pontuacao, PontuacaoDTO.class);
    }
}
