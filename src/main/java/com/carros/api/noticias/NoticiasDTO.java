package com.carros.api.noticias;

import com.google.api.client.util.DateTime;
import lombok.Data;
import org.modelmapper.ModelMapper;

@Data

public class NoticiasDTO {
    private Long id;
    private Long cidade;
    private String title;
    private String content;
    private String image;
    private String created;
    private Boolean ativo;
    private String video;
    private Double quant;
    private String tipo;
    private String credito_midia;
    private String credito_nome;
    private String credito_titulo;
    private String credito_profissao;
    private String link;

    public static NoticiasDTO create(Noticias dica) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(dica, NoticiasDTO.class);
    }



}
