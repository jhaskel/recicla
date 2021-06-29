package com.carros.api.Teste;


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
@RequestMapping("/api/v1/teste")
public class TesteController {
    @Autowired
    private TesteService service;

    @GetMapping()
    public ResponseEntity get() {
        List<TesteDTO> dicas = service.getClasse();
        return ResponseEntity.ok(dicas);
    }


    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        TesteDTO dica = service.getClasseById(id);
        return  ResponseEntity.ok(dica);

    }

    @GetMapping("/id/{id}")
    public ResponseEntity getColetandoByCidade(@PathVariable("id") Long id) {
        List<TesteDTO> coletando = service.getTesteById(id);
        return coletando.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(coletando);
    }


    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }


}
