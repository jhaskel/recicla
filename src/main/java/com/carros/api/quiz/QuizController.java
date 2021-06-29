package com.carros.api.quiz;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/quiz")
public class QuizController {
    @Autowired
    private QuizService service;

    @GetMapping()
    public ResponseEntity get() {
        List<QuizDTO> brique = service.getBrique();
        return ResponseEntity.ok(brique);
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        QuizDTO brique = service.getRotasById(id);

        return ResponseEntity.ok(brique);
    }

    @GetMapping("/categoria/{categoria}")
    public ResponseEntity getBriqueByCategoria(@PathVariable("categoria") Long categoria) {
        List<QuizDTO> coletando = service.getBriqueByCategoria(categoria);
        return coletando.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(coletando);
    }
    @GetMapping("/favoritos/{usuario}")
    public ResponseEntity getBriqueById(@PathVariable("usuario") Long usuario) {
        List<QuizDTO> coletando = service.getBriqueById(usuario);
        return coletando.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(coletando);
    }


    //calcula o total de vezes que fez um brique
    @GetMapping("/perfil/bricado/{usuario}")
    public Long getRep(@PathVariable("usuario") Long usuario) {
        return service.getPerfilBricado(usuario);
    }




    @PostMapping

    public ResponseEntity post(@RequestBody Quiz brique) {

        QuizDTO c = service.insert(brique);

        URI location = getUri(c.getId());
        return ResponseEntity.created(location).body(c);
    }

    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }

    @PutMapping("/{id}")
    public ResponseEntity put(@PathVariable("id") Long id, @RequestBody Quiz brique) {
        brique.setId(id);
        QuizDTO c = service.update(brique, id);
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
