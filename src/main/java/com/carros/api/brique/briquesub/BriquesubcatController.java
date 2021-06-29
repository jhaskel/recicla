package com.carros.api.brique.briquesub;


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
@RequestMapping("/api/v1/briquesubcat")
public class BriquesubcatController {
    @Autowired
    private BriquesubcatService service;

    @GetMapping()
    public ResponseEntity get() {
        List<BriquesubcatDTO> dicas = service.getClasse();
        return ResponseEntity.ok(dicas);
    }


    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        BriquesubcatDTO dica = service.getClasseById(id);
        return  ResponseEntity.ok(dica);

    }


    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }


}
