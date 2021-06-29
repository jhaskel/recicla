package com.carros.api.cidades;


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
@RequestMapping("/api/v1/cidades")
public class CidadeController {
    @Autowired
    private CidadeService service;

    @GetMapping()
    public ResponseEntity get() {
        List<CidadeDTO> cidades = service.getCidade();
        return ResponseEntity.ok(cidades);
    }

    @GetMapping("/{cidade}")
    public ResponseEntity getCidadeByCidade(@PathVariable("cidade") Long cidade) {
        List<CidadeDTO> cidades = service.getCidadeByCidade(cidade);
        return cidades.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(cidades);
    }


    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }


}
