package com.carros.api.apoiadoresAnuncio;

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
@RequestMapping("/api/v1/anuncio")
public class ApoiadoresAnuncioController {
    @Autowired
    private ApoiadoresAnuncioService service;

    @GetMapping()
    public ResponseEntity get() {
        List<ApoiadoresAnuncioDTO> anuncios = service.getAnuncio();
        return ResponseEntity.ok(anuncios);
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        ApoiadoresAnuncioDTO bairro = service.getAnuncioById(id);
        return  ResponseEntity.ok(bairro);

    }


    @GetMapping("aplicativo/{aplicativo}")
    public ResponseEntity getByAplicativo(@PathVariable("aplicativo") Long aplicativo) {
        List<ApoiadoresAnuncioDTO> anuncios = service.getByAplicativo(aplicativo);
        return anuncios.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(anuncios);
    }

    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }


}
