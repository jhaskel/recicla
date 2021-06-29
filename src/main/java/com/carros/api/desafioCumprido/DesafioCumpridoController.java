package com.carros.api.desafioCumprido;


import com.carros.api.desafios.DesafioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/desafio-cumprido")
public class DesafioCumpridoController {
    @Autowired
    private DesafioCumpridoService service;

    @GetMapping()
    public ResponseEntity get() {
        List<DesafioCumpridoDTO> empresas = service.getEmpresas();
        return ResponseEntity.ok(empresas);
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        DesafioCumpridoDTO empresa = service.getEmpresaById(id);

        return ResponseEntity.ok(empresa);
    }
    @GetMapping("/usuario/{usuario}")
    public ResponseEntity getDesafiosByUsuario(@PathVariable("usuario") Long usuario) {
        List<DesafioCumpridoDTO> carros = service.getDesafiosByUsuario(usuario);
        return carros.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(carros);
    }


    @GetMapping("/desafio/{usuario}/{desafio}")
    public ResponseEntity getDesafioCumpridoByUsuarioAndDesafio(@PathVariable("usuario") Long usuario,@PathVariable("desafio") Long desafio) {
        List<DesafioCumpridoDTO> carros = service.getDesafioCumpridoByUsuarioAndDesafio(usuario,desafio);
        return carros.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(carros);
    }

    @GetMapping("/soma/{usuario}/{desafio}")
    public double getRe(@PathVariable("usuario") Long usuario,@PathVariable("desafio") Long desafio) {
        return service.getRe(usuario,desafio);
    }


    @PostMapping
    public ResponseEntity post(@RequestBody DesafioCumprido empresa) {
        DesafioCumpridoDTO c = service.insert(empresa);

        URI location = getUri(c.getId());
        return ResponseEntity.created(location).body(c);
    }

    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }

    @PutMapping("/{id}")
    public ResponseEntity put(@PathVariable("id") Long id, @RequestBody DesafioCumprido empresa) {

        empresa.setId(id);
        DesafioCumpridoDTO c = service.update(empresa, id);

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
