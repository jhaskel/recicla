package com.carros.api.brique;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data

public class BriqueDTO {
    private Long id;
    private Boolean ativo;
    private Long categoria;
    private String nomecategoria;
    private Long cidade;
    private Long user;
    private String nome;
    private Long visualizado;
    private Long recompensa;
    private String title;
    private String content;
    private String created;
    private String image;
    private String celular;
    private String zap;
    private String cod;
    private Long bricado;
    private Long disponibilidade;
    private String databrique;


    public static BriqueDTO create(Brique brique) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(brique, BriqueDTO.class);
    }



}
