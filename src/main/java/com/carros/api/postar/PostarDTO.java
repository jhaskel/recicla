package com.carros.api.postar;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data

public class PostarDTO {
    private Long id;
    private Boolean ativo;
    private Long usuario;
    private Long cidade;
    private String descricao;
    private Long comentario;
    private Long likes;
    private String image;
    private String date;
    private String created;
    private String donopost;
    private String donofoto;


    public static PostarDTO create(Postar postar) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(postar, PostarDTO.class);
    }



}
