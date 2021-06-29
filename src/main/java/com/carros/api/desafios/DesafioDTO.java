package com.carros.api.desafios;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class DesafioDTO {
    private Long id;
    private Long cidade;
    private String nome;
    private String tipo;
    private Long tiposub;
    private String descricao;
    private String urlFoto;
    private String urlVideo;
    private Long quantidade;
    private Long pontuacao;
    private Boolean ativo;
    private String created;
    private String validade;

    public static DesafioDTO create(Desafio desafio) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(desafio, DesafioDTO.class);
    }
}
