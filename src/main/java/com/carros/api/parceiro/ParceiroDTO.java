package com.carros.api.parceiro;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class ParceiroDTO {
    private Long id;
    private Boolean ativo;
    private Boolean isLoja;
    private Long cidade;
    private String nome;
    private String content;
    private String  slogan;
    private String address;
    private Double latitude;
    private Double longitude;
    private String image;
    private String image2;
    private String cor;
    private String email;
    private String homepage;
    private String celular;
    private String telefone;
    private String date;
    private String tipo;

    public static ParceiroDTO create(Parceiro parceiro) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(parceiro, ParceiroDTO.class);
    }
}
