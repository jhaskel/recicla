package com.carros.api.classes;


import com.carros.api.users.Role;
import lombok.*;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.BitSet;
import java.util.Collection;
import java.util.List;

@Entity
@Data
public class Classe {
    @Id //define chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long id_cidade;
    private String nome_classe;
    private String created;
    private String tipo;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "classe_cidade",
            joinColumns = @JoinColumn(name = "classe_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "cidade_id", referencedColumnName = "id"))

    private List<Cidade> nomes;


}
