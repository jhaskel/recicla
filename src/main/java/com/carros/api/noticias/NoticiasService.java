package com.carros.api.noticias;

import com.carros.api.infra.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NoticiasService {

    @Autowired
    private NoticiasRepository rep;

    public List<NoticiasDTO> getClasse() {
        return rep.findAll().stream().map(NoticiasDTO::create).collect(Collectors.toList());
    }


    public NoticiasDTO getClasseById(Long id) {
        Optional<Noticias> classe = rep.findById(id);
        return classe.map(NoticiasDTO::create).orElseThrow(() -> new ObjectNotFoundException("Noticia não encontrada"));
    }

    public double QuantNoticia(Long cidade){
        return rep.QuantNoticia(cidade);
    }

    public List<NoticiasDTO> getColetandoByNoticias(Long cidade) {
        return rep.findByAlgo(cidade).stream().map(NoticiasDTO::create).collect(Collectors.toList());
    }
}