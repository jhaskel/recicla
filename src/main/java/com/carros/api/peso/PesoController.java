package com.carros.api.peso;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/peso")
public class PesoController {
    @Autowired
    private PesoService service;

    @GetMapping()
    public ResponseEntity get() {
        List<PesoDTO> Trajetos = service.getTrajetos();
        return ResponseEntity.ok(Trajetos);
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        PesoDTO trajeto = service.getTrajetoById(id);

        return ResponseEntity.ok(trajeto);
    }


    @PostMapping

    public ResponseEntity post(@RequestBody Peso peso) {

        PesoDTO c = service.insert(peso);

        URI location = getUri(c.getId());
        return ResponseEntity.created(location).body(c);
    }

    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }

    @PutMapping("/{id}")
    public ResponseEntity put(@PathVariable("id") Long id, @RequestBody Peso peso) {

        peso.setId(id);

        PesoDTO c = service.update(peso, id);

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
