package com.carros.api.coletando;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data

public class ColetandoDTO {
    private Long id;
    private Long cidade;
    private String dia;
    private Long idcaminhao;
    private Boolean ativo;
    private Long idrota;
    private Double latitude;
    private Double longitude;
    private String hora;
    private Long Usuario;
    private Long peso;
    private String status;
    private String created;






    public static ColetandoDTO create(Coletando dica) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(dica, ColetandoDTO.class);
    }



}
