package com.carros.api.composicaoLixo;

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
@RequestMapping("/api/v1/composicaoLixo")
public class ComposicaoLixoController {
    @Autowired
    private ComposicaoLixoService service;

    @GetMapping()
    public ResponseEntity get() {
        List<ComposicaoLixoDTO> composicaoLixo = service.getComposicaoLixo();
        return ResponseEntity.ok(composicaoLixo);
    }


    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        ComposicaoLixoDTO composicaoLixo = service.getComposicaoLixoById(id);
        return  ResponseEntity.ok(composicaoLixo);

    }
    @GetMapping("/tipo/{title}")
    public ResponseEntity getComposicaoLixoByTitle(@PathVariable("title") String title) {
        List<ComposicaoLixoDTO> composicaoLixo = service.getComposicaoLixoByTitle(title);
        return composicaoLixo.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(composicaoLixo);
    }


    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }


}
