package com.carros.api.ruas;

import com.carros.api.infra.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RuaService {

    @Autowired
    private RuaRepository rep;

    public List<RuaDTO> getRua() {
        return rep.findAll().stream().map(RuaDTO::create).collect(Collectors.toList());
    }

    public RuaDTO getRuaById(Long id) {
        Optional<Rua> rua = rep.findById(id);
        return rua.map(RuaDTO::create).orElseThrow(() -> new ObjectNotFoundException("Rua não encontrada"));
    }


    public List<RuaDTO> getRuaByCidadeAndBairro(Long cidade,Long bairro) {
        return rep.findByCidadeAndBairro(cidade,bairro).stream().map(RuaDTO::create).collect(Collectors.toList());
    }

    public List<RuaDTO> getRuByCidade(Long cidade, Long id) {
        return rep.findByCidade(cidade,id).stream().map(RuaDTO::create).collect(Collectors.toList());
    }
}