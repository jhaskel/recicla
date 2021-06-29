package com.carros.api.quiz.quizRespostas;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/quizrespostas")
public class QuizrespostasController {
    @Autowired
    private QuizrespostasService service;

    @GetMapping()
    public ResponseEntity get() {
        List<QuizrespostasDTO> dicas = service.getClasse();
        return ResponseEntity.ok(dicas);
    }


    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        QuizrespostasDTO dica = service.getClasseById(id);
        return  ResponseEntity.ok(dica);

    }

    @GetMapping("/quiz/{quiz}")
    public ResponseEntity getQuizByCategoria(@PathVariable("quiz") Long quiz) {
        List<QuizrespostasDTO> quizs = service.getQuizByQuiz(quiz);
        return quizs.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(quizs);
    }


    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }


}
