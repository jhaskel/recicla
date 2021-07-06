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
    private Long cidade;
    private Boolean ativo;
    private String content;
    private String image;
    private String title;
    private String video;
    private String tipo;

}
