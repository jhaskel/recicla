package com.carros.api.Teste;

import com.carros.api.infra.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TesteService {

    @Autowired
    private TesteRepository rep;

    public List<TesteDTO> getClasse() {
        return rep.findAll().stream().map(TesteDTO::create).collect(Collectors.toList());
    }


    public TesteDTO getClasseById(Long id) {
        Optional<Teste> classe = rep.findById(id);
        return classe.map(TesteDTO::create).orElseThrow(() -> new ObjectNotFoundException("Carro não encontrado"));
    }

    public List<TesteDTO> getTesteById(Long id) {
        return rep.findTesteById(id).stream().map(TesteDTO::create).collect(Collectors.toList());
    }
}