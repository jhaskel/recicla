package com.carros.api.ecopontos;


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
@RequestMapping("/api/v1/ecopontos")
public class EcopontosController {
    @Autowired
    private EcopontosService service;

    @GetMapping()
    public ResponseEntity get() {
        List<EcopontosDTO> dicas = service.getClasse();
        return ResponseEntity.ok(dicas);
    }

    @GetMapping("/cidade/{cidade}")
    public ResponseEntity getCidade(@PathVariable("cidade") Long cidade) {
        List<EcopontosDTO> dicas = service.getCidade(cidade);
        return  ResponseEntity.ok(dicas);

    }


    @GetMapping("/{id}")
    public ResponseEntity get2(@PathVariable("id") Long id) {
        EcopontosDTO dica = service.getClasseById(id);
        return  ResponseEntity.ok(dica);

    }

    @GetMapping("/quant")
    public double QuantDicas() {
        return service.QuantDicas();
    }





    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }


}
