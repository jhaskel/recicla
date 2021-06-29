package com.carros.api.cidades;

import com.carros.api.infra.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository rep;

    public List<CidadeDTO> getCidade() {
        return rep.findAll().stream().map(CidadeDTO::create).collect(Collectors.toList());
    }

    public List<CidadeDTO> getCidadeByCidade(Long cidade) {
        return rep.findByCidade(cidade).stream().map(CidadeDTO::create).collect(Collectors.toList());
    }
}