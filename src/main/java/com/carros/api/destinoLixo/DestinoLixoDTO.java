package com.carros.api.destinoLixo;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class DestinoLixoDTO {
    private Long id;
    private Long  id_destino;
    private boolean ativo;
    private String content;
    private Long destino;
    private String title;


    public static DestinoLixoDTO create(DestinoLixo classe) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(classe, DestinoLixoDTO.class);
    }

}
