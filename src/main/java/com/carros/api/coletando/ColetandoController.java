package com.carros.api.coletando;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/coleta")
public class ColetandoController {
    @Autowired
    private ColetandoService service;



    @GetMapping()
    public ResponseEntity get() {
        List<ColetandoDTO> coletandos = service.getColetandos();
        return ResponseEntity.ok(coletandos);
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        ColetandoDTO coletando = service.getColetandoById(id);

        return ResponseEntity.ok(coletando);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity getColetandoByCidade(@PathVariable("id") Long id) {
        List<ColetandoDTO> coletando = service.getColetandoByColeta(id);
        return coletando.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(coletando);
    }

    @GetMapping("/usuario/{usuario}")
    public ResponseEntity getColetandoByUssuario(@PathVariable("usuario") Long usuario) {
        List<ColetandoDTO> coletando = service.getColetandoByUsuario(usuario);
        return coletando.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(coletando);
    }

    @GetMapping("/usuarioDia/{usuario}/{dia}")
    public ResponseEntity getUsuarioDia(@PathVariable("usuario") Long usuario,@PathVariable("dia") String dia) {
        List<ColetandoDTO> coletando = service.getUsuarioDia(usuario,dia);
        return coletando.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(coletando);
    }


    @GetMapping("/soma/{cidade}/{bairro}/{dia}")
    public double VerificaRotaDia(@PathVariable("cidade") Long cidade,@PathVariable("bairro") Long bairro,@PathVariable("dia") String dia) {
        return service.VerificaRotaDia(cidade,bairro,dia);
    }


    @PostMapping

    public ResponseEntity post(@RequestBody Coletando coletando) {

        ColetandoDTO c = service.insert(coletando);

        URI location = getUri(c.getId());
        return ResponseEntity.created(location).body(c);
    }

    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }

    @PutMapping("/{id}")
    public ResponseEntity put(@PathVariable("id") Long id, @RequestBody Coletando coletando) {

        coletando.setId(id);

        ColetandoDTO c = service.update(coletando, id);

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
