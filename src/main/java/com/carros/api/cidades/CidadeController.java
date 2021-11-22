package com.carros.api.cidades;


import com.carros.api.usuario.Usuario;
import com.carros.api.usuario.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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


    @PostMapping
    public ResponseEntity post(@RequestBody Cidade cidade) {
        CidadeDTO c = service.insert(cidade);
        URI location = getUri(c.getId());
        return ResponseEntity.created(location).body(c);
    }

    @PutMapping("/{id}")
    public ResponseEntity put(@PathVariable("id") Long id, @RequestBody Cidade cidade) {

        cidade.setId(id);

        CidadeDTO c = service.update(cidade, id);

        return c != null ?
                ResponseEntity.ok(c) :

                ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }


    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }


}
