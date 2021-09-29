package com.carros.api.coletando.coletacrud;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data

public class ColetacrudDTO {
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
    private String created;
    private String nomerota;//deletar campo no banco
    private String nomeempresa;//deletar campo no banco
    private String tiporota;//deletar campo no banco
    private Double quant;//deletar campo no banco




    public static ColetacrudDTO create(Coletacrud dica) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(dica, ColetacrudDTO.class);
    }



}
