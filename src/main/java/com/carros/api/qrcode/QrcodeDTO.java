package com.carros.api.qrcode;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class QrcodeDTO {
    private Long id;
    private Long usuario;
    private Long cidade;
    private Boolean ativo;
    private Long ecoins;
    private Long pontos;
    private Long idloja;
    private String tipo;
    private String tipocupom;
    private String titulo;
    private String observacao;
    private String produtos;
    private String horario;
    private String date;
    private String nomeloja;
    private String codigo;
    private String qrcode;
    private String imagem;
    private Long valor;

    public static QrcodeDTO create(Qrcode cupons) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(cupons, QrcodeDTO.class);
    }
}

