package com.carros.api.ecopontos;

import com.carros.api.infra.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EcopontosService {

    @Autowired
    private EcopontosRepository rep;

    public List<EcopontosDTO> getClasse() {
        return rep.findAll2().stream().map(EcopontosDTO::create).collect(Collectors.toList());
    }

    public List<EcopontosDTO> getCidade(Long cidade) {
        return rep.findCidade(cidade).stream().map(EcopontosDTO::create).collect(Collectors.toList());
    }


    public EcopontosDTO getClasseById(Long id) {
        Optional<Ecopontos> classe = rep.findById(id);
        return classe.map(EcopontosDTO::create).orElseThrow(() -> new ObjectNotFoundException("Carro não encontrado"));
    }

    public double QuantDicas(){
        return rep.count();
    }

}