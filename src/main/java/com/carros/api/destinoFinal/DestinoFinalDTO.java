package com.carros.api.destinoFinal;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class DestinoFinalDTO {
    private Long id;
    private Long  id_destino;
    private boolean ativo;
    private String content;
    private Long destino;
    private String title;


    public static DestinoFinalDTO create(DestinoFinal classe) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(classe, DestinoFinalDTO.class);
    }

}
