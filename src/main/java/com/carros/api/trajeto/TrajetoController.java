package com.carros.api.trajeto;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/trajetos")
public class TrajetoController {
    @Autowired
    private TrajetoService service;

    @GetMapping()
    public ResponseEntity get() {
        List<TrajetoDTO> Trajetos = service.getTrajetos();
        return ResponseEntity.ok(Trajetos);
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        TrajetoDTO trajeto = service.getTrajetoById(id);

        return ResponseEntity.ok(trajeto);
    }


    @PostMapping

    public ResponseEntity post(@RequestBody Trajeto trajeto) {

        TrajetoDTO c = service.insert(trajeto);

        URI location = getUri(c.getId());
        return ResponseEntity.created(location).body(c);
    }

    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }

    @PutMapping("/{id}")
    public ResponseEntity put(@PathVariable("id") Long id, @RequestBody Trajeto trajeto) {

        trajeto.setId(id);

        TrajetoDTO c = service.update(trajeto, id);

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
