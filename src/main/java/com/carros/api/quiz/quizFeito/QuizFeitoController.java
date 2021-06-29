package com.carros.api.quiz.quizFeito;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/quizfeito")
public class QuizFeitoController {
    @Autowired
    private QuizFeitoService service;

    @GetMapping()
    public ResponseEntity get() {
        List<QuizFeitoDTO> brique = service.getBrique();
        return ResponseEntity.ok(brique);
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        QuizFeitoDTO brique = service.getRotasById(id);

        return ResponseEntity.ok(brique);
    }

    @GetMapping("/usuario/{usuario}")
    public ResponseEntity getQuizByUsuario(@PathVariable("usuario") Long usuario) {
        List<QuizFeitoDTO> coletando = service.getQuizByUsuario(usuario);
        return coletando.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(coletando);
    }
    @GetMapping("/favoritos/{usuario}")
    public ResponseEntity getBriqueById(@PathVariable("usuario") Long usuario) {
        List<QuizFeitoDTO> coletando = service.getBriqueById(usuario);
        return coletando.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(coletando);
    }


    //calcula o total de vezes que fez um brique
    @GetMapping("/perfil/bricado/{usuario}")
    public Long getRep(@PathVariable("usuario") Long usuario) {
        return service.getPerfilBricado(usuario);
    }


    //calcula o total de vezes que fez um quiz no dia
    @GetMapping("/{usuario}/{hoje}")
    public Long getQuizDia(@PathVariable("usuario") Long usuario, @PathVariable("hoje") String hoje) {
        return service.getQuizDia(usuario,hoje);
    }


    //calcula o total  quiz feito por usuario
    @GetMapping("quantQuiz/{usuario}")
    public Long getQuantQuizByUsuario(@PathVariable("usuario") Long usuario) {
        return service.getQuantQuizByUsuario(usuario);
    }




    @PostMapping

    public ResponseEntity post(@RequestBody QuizFeito brique) {

        QuizFeitoDTO c = service.insert(brique);

        URI location = getUri(c.getId());
        return ResponseEntity.created(location).body(c);
    }

    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }

    @PutMapping("/{id}")
    public ResponseEntity put(@PathVariable("id") Long id, @RequestBody QuizFeito brique) {
        brique.setId(id);
        QuizFeitoDTO c = service.update(brique, id);
        return c != null ?
                ResponseEntity.ok(c) :
                ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        service.delete(id);

        return ResponseEntity.ok().build();
    }
}
