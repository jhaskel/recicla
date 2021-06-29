package com.carros.api.bairro;

import com.carros.api.infra.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BairroService {

    @Autowired
    private BairroRepository rep;

    public List<BairroDTO> getBairro() {
        return rep.findAll().stream().map(BairroDTO::create).collect(Collectors.toList());
    }

    public BairroDTO getBairroById(Long id) {
        Optional<Bairro> bairro = rep.findById(id);
        return bairro.map(BairroDTO::create).orElseThrow(() -> new ObjectNotFoundException("Bairro não encontrada"));
    }


    public List<BairroDTO> getBairroByCidade(Long cidade) {
        return rep.findByCidade(cidade).stream().map(BairroDTO::create).collect(Collectors.toList());
    }

    public List<BairroDTO> getBaiByCidade(Long cidade,Long id) {
        return rep.findBaiByCidade(cidade,id).stream().map(BairroDTO::create).collect(Collectors.toList());

    }
}