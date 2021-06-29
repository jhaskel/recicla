package com.carros.api.noticias;


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
@RequestMapping("/api/v1/noticias")
public class NoticiasController {
    @Autowired
    private NoticiasService service;

    @GetMapping()
    public ResponseEntity get() {
        List<NoticiasDTO> noticias = service.getClasse();
        return ResponseEntity.ok(noticias);
    }


    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        NoticiasDTO noticia = service.getClasseById(id);
        return  ResponseEntity.ok(noticia);

    }

    @GetMapping("/cidade/{cidade}")
    public ResponseEntity getColetandoByNoticias(@PathVariable("cidade") Long cidade) {
        List<NoticiasDTO> noticia = service.getColetandoByNoticias(cidade);
        return noticia.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(noticia);
    }

    @GetMapping("/quant/{cidade}")
    public double QuantNoticia(@PathVariable("cidade") Long cidade) {
        return service.QuantNoticia(cidade);
    }



    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }


}
