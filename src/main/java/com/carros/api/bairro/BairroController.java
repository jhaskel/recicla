package com.carros.api.bairro;

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
@RequestMapping("/api/v1/bairros")
public class BairroController {
    @Autowired
    private BairroService service;

    @GetMapping()
    public ResponseEntity get() {
        List<BairroDTO> bairros = service.getBairro();
        return ResponseEntity.ok(bairros);
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        BairroDTO bairro = service.getBairroById(id);
        return  ResponseEntity.ok(bairro);

    }

    @GetMapping("cidade/{cidade}")
    public ResponseEntity getBairroByCidade(@PathVariable("cidade") Long cidade) {
        List<BairroDTO> bairros = service.getBairroByCidade(cidade);
        return bairros.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(bairros);
    }

    @GetMapping("cidade/{cidade}/id/{id}")
    public ResponseEntity getBaiByCidade(@PathVariable("cidade") Long cidade,@PathVariable("id") Long id) {
        List<BairroDTO> bairros = service.getBaiByCidade(cidade,id);
        return bairros.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(bairros);
    }

    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }


}
