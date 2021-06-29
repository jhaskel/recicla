package com.carros.api.classes;


import com.carros.api.infra.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClasseService {

    @Autowired
    private ClasseRepository rep;

    public List<ClasseDTO> getClasse() {
        return rep.findAlll().stream().map(ClasseDTO::create).collect(Collectors.toList());
    }



    public ClasseDTO getClasseById(Long id) {
        Optional<Classe> classe = rep.findById(id);
        return classe.map(ClasseDTO::create).orElseThrow(() -> new ObjectNotFoundException("Carro não encontrado"));
    }

    public List<ClasseDTO> getClasseByTipo(String tipo) {
        return rep.findByTipo(tipo).stream().map(ClasseDTO::create).collect(Collectors.toList());
    }


    public List<ClasseDTO> getClasseByDestinoTipo(String tipo) {
        return rep.findByTipo(tipo).stream().map(ClasseDTO::create).collect(Collectors.toList());
    }
}