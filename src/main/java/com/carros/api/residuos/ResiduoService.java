package com.carros.api.residuos;

import com.carros.api.infra.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ResiduoService {

    @Autowired
    private ResiduoRepository rep;

    public double getRe(Long year, Long cidade){
        return rep.findSoma(year,cidade);
    }


    public List<ResiduoDTO> getResiduo() {
        return rep.findAll().stream().map(ResiduoDTO::create).collect(Collectors.toList());
    }

    public ResiduoDTO getResiduoById(Long id) {
        Optional<Residuo> residuo = rep.findById(id);
        return residuo.map(ResiduoDTO::create).orElseThrow(() -> new ObjectNotFoundException("Residuo não encontrado"));
    }

    public List<ResiduoDTO> getResiduoByTipo(String tipo) {
        return rep.findByTipo(tipo).stream().map(ResiduoDTO::create).collect(Collectors.toList());
    }


    public List<ResiduoDTO> getResiduoByYear(Long year) {
        return rep.findByYear(year).stream().map(ResiduoDTO::create).collect(Collectors.toList());

    }

    public List<ResiduoDTO> getResiduoByCidade(Long cidade, Long year) {
        return rep.findByCidadeAndYear(cidade,year).stream().map(ResiduoDTO::create).collect(Collectors.toList());

    }

    public ResiduoDTO getResiduoByCidadeTotal(Long year) {
        Optional<Residuo> residuo = rep.findByTotal(year);
        return residuo.map(ResiduoDTO::create).orElseThrow(() -> new ObjectNotFoundException("Residuo não encontrado"));
    }

    public List<ResiduoDTO> getResiduoByDestino(Long cidade, Long year) {
        return rep.findByDestino(cidade,year).stream().map(ResiduoDTO::create).collect(Collectors.toList());
    }


    public List<ResiduoDTO> getMetas(Long cidade, Long year) {
        return rep.findMetas(cidade,year).stream().map(ResiduoDTO::create).collect(Collectors.toList());
    }
}




