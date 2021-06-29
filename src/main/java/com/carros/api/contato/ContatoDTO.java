package com.carros.api.contato;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class ContatoDTO {
    private Long id;
    private Long usuario;
    private Long cidade;
    private Long setor;
    private String assunto;
    private String descricao;
    private Long ano;
    private Long mes;
    private String date;



    public static ContatoDTO create(Contato contato) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(contato, ContatoDTO.class);
    }
}
