package com.carros.api.composicaoLixo;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class ComposicaoLixoDTO {
    private Long id;
    private String aviso;
    private boolean aviso1;
    private boolean aviso2;
    private String avisos;
    private String content;
    private String contentNo;
    private String image;
    private String title;


    public static ComposicaoLixoDTO create(ComposicaoLixo classe) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(classe, ComposicaoLixoDTO.class);
    }

}
