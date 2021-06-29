package com.carros.api.logistica.logisticaTipo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/logistica_tipo")
public class LogisticaTipoController {
    @Autowired
    private LogisticaTipoService service;

    @GetMapping()
    public ResponseEntity get() {
        List<LogisticaTipoDTO> dicas = service.getClasse();
        return ResponseEntity.ok(dicas);
    }


    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        LogisticaTipoDTO dica = service.getClasseById(id);
        return  ResponseEntity.ok(dica);

    }

    @GetMapping("all/{id}")
    public ResponseEntity getAll(@PathVariable("id") Long id) {
        List<LogisticaTipoDTO> pontuacaos = service.getAll(id);
        return pontuacaos.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(pontuacaos);
    }


    @PostMapping
    public ResponseEntity post(@RequestBody LogisticaTipo pontuacao) {

        LogisticaTipoDTO c = service.insert(pontuacao);

        URI location = getUri(c.getId());
        return ResponseEntity.created(location).body(c);
    }

    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }

    @PutMapping("/{id}")
    public ResponseEntity put(@PathVariable("id") Long id, @RequestBody LogisticaTipo pontuacao) {

        pontuacao.setId(id);

        LogisticaTipoDTO c = service.update(pontuacao, id);

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
