package com.carros.api.cupomMeus;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class CupomMeusDTO {

    private Long id;
    private Long usuario;
    private Long cidade;
    private Boolean ativo;
    private Long ecoins;
    private Long pontos;
    private Long idloja;
    private Long qtde;
    private String tipo;
    private String tipocupom;
    private String titulo;
    private String observacao;
    private String produtos;
    private String horario;
    private String date;
    private String nomeloja;
    private String nomeusuario;
    private String codigo;
    private String qrcode;
    private String imagem;
    private Long valor;
    private Boolean isonline;
    private String created;
    private String modified;


    public static CupomMeusDTO create(CupomMeus cupons) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(cupons, CupomMeusDTO.class);
    }
}

