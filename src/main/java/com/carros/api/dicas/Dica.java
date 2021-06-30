package com.carros.api.dicas;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Dica {
    @Id //define chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long icone;
    private String title;
    private String content;
    private String image;
    private String created;
    private Boolean ativo;
    private String video;
    private String tipo;
    private String credito_midia;
    private String credito_nome;
    private String credito_titulo;
    private String credito_profissao;
    private String link;


}
