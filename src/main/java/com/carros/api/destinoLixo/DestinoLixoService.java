package com.carros.api.destinoLixo;

import com.carros.api.infra.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DestinoLixoService {
    @Autowired
    private DestinoLixoRepository rep;

    public List<DestinoLixoDTO> getDestinoLixo() {
        return rep.findAll().stream().map(DestinoLixoDTO::create).collect(Collectors.toList());
    }

    public DestinoLixoDTO getDestinoLixoById(Long id) {
        Optional<DestinoLixo> destinoLixo = rep.findById(id);
        return destinoLixo.map(DestinoLixoDTO::create).orElseThrow(() -> new ObjectNotFoundException("Destino não encontrado"));
    }

    public List<DestinoLixoDTO> getDestinoLixoByTitle(String title) {
        return rep.findByTitle(title).stream().map(DestinoLixoDTO::create).collect(Collectors.toList());
    }

}