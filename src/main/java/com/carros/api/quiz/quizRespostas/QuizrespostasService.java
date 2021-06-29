package com.carros.api.quiz.quizRespostas;

import com.carros.api.infra.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuizrespostasService {

    @Autowired
    private QuizrespostasRepository rep;

    public List<QuizrespostasDTO> getClasse() {
        return rep.findAll().stream().map(QuizrespostasDTO::create).collect(Collectors.toList());
    }


    public QuizrespostasDTO getClasseById(Long id) {
        Optional<Quizrespostas> classe = rep.findById(id);
        return classe.map(QuizrespostasDTO::create).orElseThrow(() -> new ObjectNotFoundException("Carro não encontrado"));
    }

    public List<QuizrespostasDTO> getQuizByQuiz(Long quiz) {
        return rep.findByQuiz(quiz).stream().map(QuizrespostasDTO::create).collect(Collectors.toList());
    }
}