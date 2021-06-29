package com.carros.api.brique;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/brique")
public class BriqueController {
    @Autowired
    private BriqueService service;

    @GetMapping()
    public ResponseEntity get() {
        List<BriqueDTO> brique = service.getBrique();
        return ResponseEntity.ok(brique);
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        BriqueDTO brique = service.getRotasById(id);

        return ResponseEntity.ok(brique);
    }

    @GetMapping("/cidade/{cidade}")
    public ResponseEntity getBriqueByCidade(@PathVariable("cidade") Long cidade) {
        List<BriqueDTO> coletando = service.getBriqueByCidade(cidade);
        return coletando.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(coletando);
    }
    @GetMapping("/favoritos/{usuario}")
    public ResponseEntity getBriqueById(@PathVariable("usuario") Long usuario) {
        List<BriqueDTO> coletando = service.getBriqueById(usuario);
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
    public ResponseEntity post(@RequestBody Brique brique) {
        BriqueDTO c = service.insert(brique);
        URI location = getUri(c.getId());
        return ResponseEntity.created(location).body(c);
    }

    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }

    @PutMapping("/{id}")
    public ResponseEntity put(@PathVariable("id") Long id, @RequestBody Brique brique) {
        brique.setId(id);
        BriqueDTO c = service.update(brique, id);
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
