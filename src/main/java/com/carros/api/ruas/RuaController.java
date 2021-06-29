package com.carros.api.ruas;

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
@RequestMapping("/api/v1/ruas")
public class RuaController {
    @Autowired
    private RuaService service;

    @GetMapping()
    public ResponseEntity get() {
        List<RuaDTO> ruas = service.getRua();
        return ResponseEntity.ok(ruas);
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        RuaDTO rua = service.getRuaById(id);
        return  ResponseEntity.ok(rua);

    }

    @GetMapping("bairro/{cidade}/{bairro}")
    public ResponseEntity getRuaByCidadeAndBairro(@PathVariable("cidade") Long cidade,@PathVariable("bairro") Long bairro) {
        List<RuaDTO> ruas = service.getRuaByCidadeAndBairro(cidade,bairro);
        return ruas.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(ruas);
    }
    @GetMapping("cidade/{cidade}/{id}")
    public ResponseEntity getRuByCidade(@PathVariable("cidade") Long cidade,@PathVariable("id") Long id) {
        List<RuaDTO> ruas = service.getRuByCidade(cidade,id);
        return ruas.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(ruas);
    }

    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }


}
