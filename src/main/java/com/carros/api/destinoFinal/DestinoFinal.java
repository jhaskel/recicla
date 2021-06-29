package com.carros.api.destinoFinal;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class DestinoFinal {
    @Id //define chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long  id_destino;
    private boolean ativo;
    private String content;
    private Long destino;
    private String title;

}
