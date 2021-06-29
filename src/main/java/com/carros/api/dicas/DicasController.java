package com.carros.api.dicas;


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
@RequestMapping("/api/v1/dicas")
public class DicasController {
    @Autowired
    private DicasService service;

    @GetMapping()
    public ResponseEntity get() {
        List<DicasDTO> dicas = service.getClasse();
        return ResponseEntity.ok(dicas);
    }


    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        DicasDTO dica = service.getClasseById(id);
        return  ResponseEntity.ok(dica);

    }

    @GetMapping("/quant")
    public double QuantDicas() {
        return service.QuantDicas();
    }

    @GetMapping("/quantLidas")
    public long QuantLidas() {
        return service.QuantLidas();
    }



    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }


}
