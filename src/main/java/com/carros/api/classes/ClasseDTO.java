package com.carros.api.classes;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;
@Data

public class ClasseDTO {
    private Long id;
    private Long id_cidade;
    private String nome_classe;
    private String created;
    private String tipo;
    private String nome;

    public static ClasseDTO create(Classe residuo) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(residuo, ClasseDTO.class);
    }



}
