package com.carros.api.classes;


import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Data
public class Cidade implements GrantedAuthority {
    @Id //define chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String nome;

    @Override
    public String getAuthority() {
        return nome;
    }
}
