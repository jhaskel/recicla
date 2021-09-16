package com.carros.api.parceiro.parceiroCupons;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class ParceiroCuponsDTO {
    private Long id;
    private Boolean ativo;
    private Long idloja;
    private String titulo;
    private String patrocinador;
    private String observacao;
    private Long desconto;
    private String horario;
    private String produtos;
    private Long quantidade;
    private Long estoque;
    private String tipo;
    private String tipocupom;
    private Long valor;
    private String imagem;
    private String created;
    private Long cidade;
    private Boolean isonline;

    public static ParceiroCuponsDTO create(ParceiroCupons parceiro) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(parceiro, ParceiroCuponsDTO.class);
    }
}
