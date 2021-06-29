package com.carros.api.destinoLixo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/destinoLixo")
public class DestinoLixoController {
    @Autowired
    private DestinoLixoService service;

    @GetMapping()
    public ResponseEntity get() {
        List<DestinoLixoDTO> destinoLixo = service.getDestinoLixo();
        return ResponseEntity.ok(destinoLixo);
    }


    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        DestinoLixoDTO destinoLixo = service.getDestinoLixoById(id);
        return  ResponseEntity.ok(destinoLixo);

    }
    @GetMapping("/tipo/{title}")
    public ResponseEntity getDestinoLixoByTitle(@PathVariable("title") String title) {
        List<DestinoLixoDTO> destinoLixo = service.getDestinoLixoByTitle(title);
        return destinoLixo.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(destinoLixo);
    }


    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }


}
