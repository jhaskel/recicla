package com.carros.api.home.homecidade;


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
@RequestMapping("/api/v1/homecidade")
public class HomecidadeController {
    @Autowired
    private HomecidadeService service;

    @GetMapping()
    public ResponseEntity get() {
        List<HomecidadeDTO> dicas = service.getClasse();
        return ResponseEntity.ok(dicas);
    }


    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        HomecidadeDTO dica = service.getClasseById(id);
        return  ResponseEntity.ok(dica);

    }
    @GetMapping("/cidade/{cidade}")
    public ResponseEntity getColetandoByNoticias(@PathVariable("cidade") Long cidade) {
        List<HomecidadeDTO> noticia = service.getColetandoByNoticias(cidade);
        return noticia.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(noticia);
    }



    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }


}
