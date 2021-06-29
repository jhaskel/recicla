package com.carros.api.brique.briqueCategoria;

import com.carros.api.infra.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BriquecategoriaService {

    @Autowired
    private BriquecategoriaRepository rep;

    public List<BriquecategoriaDTO> getClasse() {
        return rep.findAll().stream().map(BriquecategoriaDTO::create).collect(Collectors.toList());
    }


    public BriquecategoriaDTO getClasseById(Long id) {
        Optional<Briquecategoria> classe = rep.findById(id);
        return classe.map(BriquecategoriaDTO::create).orElseThrow(() -> new ObjectNotFoundException("Carro não encontrado"));
    }

}