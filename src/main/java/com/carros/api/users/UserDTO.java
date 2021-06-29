package com.carros.api.users;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {
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
    // token jwt
    private String token;
    private String tipo;
    private Long empresa;
    private String address;
    private List<String> roles;
    private Long quantdicas;
    private Long quantnoticias;
    private Boolean ativo;
    private Long regiao;
    private String logadoem;


    public static UserDTO create(User user) {
        ModelMapper modelMapper = new ModelMapper();
        UserDTO dto = modelMapper.map(user, UserDTO.class);
        dto.roles = user.getRoles().stream()
                .map(Role::getNome)
                .collect(Collectors.toList());
        return dto;
    }

    public static UserDTO create(User user, String token) {
        UserDTO dto = create(user);
        dto.token = token;
        return dto;
    }

    public String toJson() throws JsonProcessingException {
        ObjectMapper m = new ObjectMapper();
        return m.writeValueAsString(this);
    }
}
