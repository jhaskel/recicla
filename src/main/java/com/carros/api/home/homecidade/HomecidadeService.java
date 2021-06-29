package com.carros.api.home.homecidade;

import com.carros.api.infra.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HomecidadeService {

    @Autowired
    private HomecidadeRepository rep;

    public List<HomecidadeDTO> getClasse() {
        return rep.findAll().stream().map(HomecidadeDTO::create).collect(Collectors.toList());
    }


    public HomecidadeDTO getClasseById(Long id) {
        Optional<Homecidade> classe = rep.findById(id);
        return classe.map(HomecidadeDTO::create).orElseThrow(() -> new ObjectNotFoundException("Carro não encontrado"));
    }

    public List<HomecidadeDTO> getColetandoByNoticias(Long cidade) {
        return rep.findByAlgo(cidade).stream().map(HomecidadeDTO::create).collect(Collectors.toList());
    }
}