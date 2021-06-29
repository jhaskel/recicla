package com.carros.api.composicaoLixo;

import com.carros.api.infra.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ComposicaoLixoService {

    @Autowired
    private ComposicaoLixoRepository rep;

    public List<ComposicaoLixoDTO> getComposicaoLixo() {
        return rep.findAll().stream().map(ComposicaoLixoDTO::create).collect(Collectors.toList());
    }


    public ComposicaoLixoDTO getComposicaoLixoById(Long id) {
        Optional<ComposicaoLixo> composicaoLixo = rep.findById(id);
        return composicaoLixo.map(ComposicaoLixoDTO::create).orElseThrow(() -> new ObjectNotFoundException("Carro não encontrado"));
    }

    public List<ComposicaoLixoDTO> getComposicaoLixoByTitle(String title) {
        return rep.findByTitle(title).stream().map(ComposicaoLixoDTO::create).collect(Collectors.toList());
    }


}