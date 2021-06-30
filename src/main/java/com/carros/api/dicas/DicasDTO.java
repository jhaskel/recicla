package com.carros.api.dicas;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data

public class DicasDTO {
    private Long id;
    private Long icone;
    private String title;
    private String content;
    private String image;
    private String created;
    private Boolean ativo;
    private String video;
    private String tipo;
    private String credito_midia;
    private String credito_nome;
    private String credito_titulo;
    private String credito_profissao;
    private String link;

    public static DicasDTO create(Dica dica) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(dica, DicasDTO.class);
    }



}
