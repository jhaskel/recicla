package com.carros.api.home;

import com.carros.api.infra.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HomeService {

    @Autowired
    private HomeRepository rep;

    public List<HomeDTO> getClasse() {
        return rep.findAll().stream().map(HomeDTO::create).collect(Collectors.toList());
    }


    public HomeDTO getClasseById(Long id) {
        Optional<Home> classe = rep.findById(id);
        return classe.map(HomeDTO::create).orElseThrow(() -> new ObjectNotFoundException("Carro não encontrado"));
    }

}