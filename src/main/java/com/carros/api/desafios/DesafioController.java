package com.carros.api.desafios;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/desafios")
public class DesafioController {
    @Autowired
    private DesafioService service;


    @GetMapping()
    public ResponseEntity get() {
        List<DesafioDTO> desafios = service.getDesafios();
        return ResponseEntity.ok(desafios);
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        DesafioDTO carro = service.getCarroById(id);

        return ResponseEntity.ok(carro);
    }

    @GetMapping("/tipo/{tipo}")
    public ResponseEntity getDesafiosByTipo(@PathVariable("tipo") String tipo) {
        List<DesafioDTO> carros = service.getDesafiosByTipo(tipo);
        return carros.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(carros);
    }


    @PostMapping
    @Secured({ "ROLE_ADMIN" })
    public ResponseEntity post(@RequestBody Desafio carro) {

        DesafioDTO c = service.insert(carro);

        URI location = getUri(c.getId());
        return ResponseEntity.created(location).body(c);
    }

    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }
    

    @PutMapping("/{id}")
    public ResponseEntity put(@PathVariable("id") Long id, @RequestBody Desafio carro) {

        carro.setId(id);

        DesafioDTO c = service.update(carro, id);

        return c != null ?
                ResponseEntity.ok(c) :
                ResponseEntity.notFound().build();
    }
    @GetMapping("/cidade/{cidade}/{usuario}")
    public ResponseEntity getColetandoByDesafios(@PathVariable("cidade") Long cidade,@PathVariable("usuario") Long usuario) {
        List<DesafioDTO> noticia = service.getColetandoByDesafios(cidade,usuario);
        return noticia.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(noticia);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        service.delete(id);

        return ResponseEntity.ok().build();
    }
}
