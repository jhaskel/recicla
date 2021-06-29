package com.carros.api.empresa;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data

public class EmpresaDTO {
    private Long id;
    private Long cidade;
    private String nome;
    private String image;
    private Double latitude;
    private Double longitude;
    private String endereco;
    private String bairro;
    private String nomecidade;
    private String telefone;
    private String celular;
    private String contato;
    private String cnpj;
    private String cep;
    private String teste;


    public static EmpresaDTO create(Empresa dica) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(dica, EmpresaDTO.class);
    }



}
