package com.carros.api.dicas;

import com.carros.api.infra.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DicasService {

    @Autowired
    private DicasRepository rep;

    public List<DicasDTO> getClasse() {
        return rep.findAll2().stream().map(DicasDTO::create).collect(Collectors.toList());
    }

    public List<DicasDTO> getCidade(Long cidade) {
        return rep.findCidade(cidade).stream().map(DicasDTO::create).collect(Collectors.toList());
    }


    public DicasDTO getClasseById(Long id) {
        Optional<Dica> classe = rep.findById(id);
        return classe.map(DicasDTO::create).orElseThrow(() -> new ObjectNotFoundException("Carro não encontrado"));
    }

    public double QuantDicas(){
        return rep.count();
    }
    public long QuantLidas(Long user){ return rep.findQuantLidas(user); }

}