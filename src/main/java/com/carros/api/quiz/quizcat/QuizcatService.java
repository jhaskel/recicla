package com.carros.api.quiz.quizcat;

import com.carros.api.infra.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuizcatService {

    @Autowired
    private QuizcatRepository rep;

    public List<QuizcatDTO> getClasse() {
        return rep.findAll().stream().map(QuizcatDTO::create).collect(Collectors.toList());
    }


    public QuizcatDTO getClasseById(Long id) {
        Optional<Quizcat> classe = rep.findById(id);
        return classe.map(QuizcatDTO::create).orElseThrow(() -> new ObjectNotFoundException("Carro não encontrado"));
    }

}