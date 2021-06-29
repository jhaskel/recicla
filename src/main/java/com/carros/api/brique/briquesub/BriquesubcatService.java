package com.carros.api.brique.briquesub;

import com.carros.api.infra.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BriquesubcatService {

    @Autowired
    private BriquesubcatRepository rep;

    public List<BriquesubcatDTO> getClasse() {
        return rep.findAll().stream().map(BriquesubcatDTO::create).collect(Collectors.toList());
    }


    public BriquesubcatDTO getClasseById(Long id) {
        Optional<Briquesubcat> classe = rep.findById(id);
        return classe.map(BriquesubcatDTO::create).orElseThrow(() -> new ObjectNotFoundException("Carro não encontrado"));
    }

}