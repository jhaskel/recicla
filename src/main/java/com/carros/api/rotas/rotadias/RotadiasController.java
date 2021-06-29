package com.carros.api.rotas.rotadias;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/rotadias")
public class RotadiasController {
    @Autowired
    private RotadiasService service;

    @GetMapping()
    public ResponseEntity get() {
        List<RotadiasDTO> rotas = service.getRotass();
        return ResponseEntity.ok(rotas);
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        RotadiasDTO rota = service.getRotasById(id);

        return ResponseEntity.ok(rota);
    }

    @GetMapping("/rota/{rota}")
    public ResponseEntity getColetandoByRota(@PathVariable("rota") Long rota) {
        List<RotadiasDTO> coletando = service.getRotasByRota(rota);
        return coletando.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(coletando);
    }

    @GetMapping("/bairro/{bairro}")
    public ResponseEntity getColetandoByBairro(@PathVariable("bairro") Long bairro) {
        List<RotadiasDTO> coletando = service.getRotasByBairro(bairro);
        return coletando.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(coletando);
    }


    @PostMapping
    @Secured({ "ROLE_ADMIN" })
    public ResponseEntity post(@RequestBody Rotadias rota) {

        RotadiasDTO c = service.insert(rota);

        URI location = getUri(c.getId());
        return ResponseEntity.created(location).body(c);
    }

    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }

    @PutMapping("/{id}")
    public ResponseEntity put(@PathVariable("id") Long id, @RequestBody Rotadias rota) {

        rota.setId(id);

        RotadiasDTO c = service.update(rota, id);

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
