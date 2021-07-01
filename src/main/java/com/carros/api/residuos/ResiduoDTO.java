package com.carros.api.residuos;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class ResiduoDTO {
    private Long id;
    private Long id_destino;
    private String nome_destino;
    private String tipo;
    private Long year;
    private Long cidade;
    private Double quantidade;
    private String created;
    private String cor;
    private String link;
    private Long mes;
    private Double quant;
    private Double quant2;


    public static ResiduoDTO create(Residuo residuo) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(residuo, ResiduoDTO.class);
    }

}
