package com.carros.api.campanha;

import com.carros.api.infra.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CampanhaService {

    @Autowired
    private CampanhaRepository rep;

    public List<CampanhaDTO> getClasse() {
        return rep.findAll().stream().map(CampanhaDTO::create).collect(Collectors.toList());
    }


    public CampanhaDTO getClasseById(Long id) {
        Optional<Campanha> classe = rep.findById(id);
        return classe.map(CampanhaDTO::create).orElseThrow(() -> new ObjectNotFoundException("Carro não encontrado"));
    }

    public List<CampanhaDTO> getLogisticaByCidade(Long cidade) {
        return rep.findLogisticaByCidade(cidade).stream().map(CampanhaDTO::create).collect(Collectors.toList());
    }

    public List<CampanhaDTO> getLogisticaByTipo(Long cidade, String tipo) {
        return rep.findLogisticaByTipo(cidade,tipo).stream().map(CampanhaDTO::create).collect(Collectors.toList());
    }
}