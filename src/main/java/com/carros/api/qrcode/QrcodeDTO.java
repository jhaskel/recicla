package com.carros.api.qrcode;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class QrcodeDTO {
    private Long id;
    private String qrcode;
    private Long cidade;
    private String tipo;
    private String tipotipo;
    private String codigo;
    private Long idloja;
    private Long valor;
    private Boolean ativo;


    public static QrcodeDTO create(Qrcode cupons) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(cupons, QrcodeDTO.class);
    }
}

