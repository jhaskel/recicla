package com.carros.api.coletando.coletacrud;



import com.carros.api.coletando.ColetandoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/coletacrud")
public class ColetacrudController {
    @Autowired
    private ColetacrudService service;



    @GetMapping()
    public ResponseEntity get() {
        List<ColetacrudDTO> coletandos = service.getColetandos();
        return ResponseEntity.ok(coletandos);
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        ColetacrudDTO coletando = service.getColetandoById(id);

        return ResponseEntity.ok(coletando);
    }
    @GetMapping("/cidade/{cidade}/{dia}/{bairro}")
    public ResponseEntity getColetandoByCidade(@PathVariable("cidade") Long cidade,@PathVariable("dia") String dia,@PathVariable("idcaminhao") Long idcaminhao) {
        List<ColetacrudDTO> coletando = service.getColetacrudByCidade(cidade,dia,idcaminhao);
        return coletando.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(coletando);
    }

    @GetMapping("/usuarioDia/{usuario}/{dia}")
    public ResponseEntity getUsuarioDia(@PathVariable("usuario") Long usuario,@PathVariable("dia") String dia) {
        List<ColetacrudDTO> coletando = service.getUsuarioDia(usuario,dia);
        return coletando.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(coletando);
    }



    @PostMapping
    @Secured({ "ROLE_ADMIN" })
    public ResponseEntity post(@RequestBody Coletacrud coletando) {

        ColetacrudDTO c = service.insert(coletando);

        URI location = getUri(c.getId());
        return ResponseEntity.created(location).body(c);
    }

    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }

    @PutMapping("/{id}")
    public ResponseEntity put(@PathVariable("id") Long id, @RequestBody Coletacrud coletando) {

        coletando.setId(id);

        ColetacrudDTO c = service.update(coletando, id);

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
