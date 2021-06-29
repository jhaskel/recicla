package com.carros.api.campanha;


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
@RequestMapping("/api/v1/campanha")
public class CampanhaController {
    @Autowired
    private CampanhaService service;

    @GetMapping()
    public ResponseEntity get() {
        List<CampanhaDTO> dicas = service.getClasse();
        return ResponseEntity.ok(dicas);
    }


    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        CampanhaDTO dica = service.getClasseById(id);
        return  ResponseEntity.ok(dica);

    }
    @GetMapping("cidade/{cidade}")
    public ResponseEntity getLogisticaByCidade(@PathVariable("cidade") Long cidade) {
        List<CampanhaDTO> pontuacaos = service.getLogisticaByCidade(cidade);
        return pontuacaos.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(pontuacaos);
    }

    @GetMapping("tipo/{cidade}/{tipo}")
    public ResponseEntity getLogisticaByTipo(@PathVariable("cidade") Long cidade,@PathVariable("tipo") String tipo) {
        List<CampanhaDTO> pontuacaos = service.getLogisticaByTipo(cidade,tipo);
        return pontuacaos.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(pontuacaos);
    }


    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }


}
