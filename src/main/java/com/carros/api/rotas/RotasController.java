package com.carros.api.rotas;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/rotas")
public class RotasController {
    @Autowired
    private RotasService service;

    @GetMapping()
    public ResponseEntity get() {
        List<RotasDTO> rotas = service.getRotass();
        return ResponseEntity.ok(rotas);
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        RotasDTO rota = service.getRotasById(id);

        return ResponseEntity.ok(rota);
    }

    @GetMapping("/cidade/{cidade}")
    public ResponseEntity getColetandoByCidade(@PathVariable("cidade") Long cidade) {
        List<RotasDTO> coletando = service.getRotasByCidade(cidade);
        return coletando.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(coletando);
    }


    @PostMapping
    @Secured({ "ROLE_ADMIN" })
    public ResponseEntity post(@RequestBody Rotas rota) {

        RotasDTO c = service.insert(rota);

        URI location = getUri(c.getId());
        return ResponseEntity.created(location).body(c);
    }

    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }

    @PutMapping("/{id}")
    public ResponseEntity put(@PathVariable("id") Long id, @RequestBody Rotas rota) {

        rota.setId(id);

        RotasDTO c = service.update(rota, id);

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
