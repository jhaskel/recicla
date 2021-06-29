package com.carros.api.appConf;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class AppConfDTO {
    private Long id;
    private Boolean anuncio;
    private double ecoins;
    private Long quizdiario;
    private Long briquemes;



    public static AppConfDTO create(AppConf classe) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(classe, AppConfDTO.class);
    }

}
