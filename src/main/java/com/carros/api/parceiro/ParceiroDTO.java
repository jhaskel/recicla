package com.carros.api.parceiro;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class ParceiroDTO {
    private Long id;
    private String nome;
    private String email;
    private String address;
    private Boolean ativo;
    private Boolean isloja;
    private String celular;
    private Long cidade;
    private String content;
    private String created;
    private String image;
    private String image2;
    private Double latitude;
    private Double longitude;
    private String slogan;
    private String telefone;
    private String tipo;
    public static ParceiroDTO create(Parceiro parceiro) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(parceiro, ParceiroDTO.class);
    }
}
