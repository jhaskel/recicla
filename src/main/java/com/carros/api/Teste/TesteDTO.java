package com.carros.api.Teste;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data

public class TesteDTO {
    private Long id;
    private String nome;
    private String login;
    private String senha;
    private String email;
    private String urlFoto;
    private Long cidade;
    private Long bairro;
    private Long rua;
    private String celular;
    private String nascimento;
    private String genero;
    private String local;
    private Long distancia;
    private Double latitude;
    private Double longitude;

    public static TesteDTO create(Teste dica) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(dica, TesteDTO.class);
    }



}
