package com.carros.api.home.homecidade;

import com.carros.api.home.Home;
import lombok.Data;
import org.modelmapper.ModelMapper;

@Data

public class HomecidadeDTO {
    private Long id;
    private Long home;
    private Long cidade;
    private Boolean ativo;
    private Long posicao;
    private String titulo;
    private String icone;




    public static HomecidadeDTO create(Homecidade dica) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(dica, HomecidadeDTO.class);
    }



}
