package com.carros.api.dicas;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data

public class DicasDTO {
    private Long id;
    private Long cidade;
    private Boolean ativo;
    private String content;
    private String image;
    private String title;
    private String video;
    private String tipo;

    public static DicasDTO create(Dica dica) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(dica, DicasDTO.class);
    }



}
