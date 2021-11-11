package com.carros.api.parceiro;

import com.carros.api.usuario.Usuario;
import com.carros.api.usuario.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/parceiro")
public class ParceiroController {
    @Autowired
    private ParceiroService service;

    @GetMapping()
    public ResponseEntity get() {
        List<ParceiroDTO> pontuacaos = service.getPontuacaos();
        return ResponseEntity.ok(pontuacaos);

    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        ParceiroDTO pontuacao = service.getPontuacaoById(id);
        return ResponseEntity.ok(pontuacao);
    }

    @GetMapping("cidade/{cidade}")
    public ResponseEntity getParceiroByCidade(@PathVariable("cidade") Long cidade) {
        List<ParceiroDTO> parceiros = service.getParceiroByCidade(cidade);
        return parceiros.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(parceiros);
    }
    @GetMapping("id/{id}")
    public ResponseEntity getParceiroById(@PathVariable("id") Long id) {
        List<ParceiroDTO> parceiros = service.getParceiroById(id);
        return parceiros.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(parceiros);
    }

    @GetMapping("idLoja/{id}")
    public ResponseEntity getIdLoja(@PathVariable("id") Long id) {
        List<ParceiroDTO> parceiros = service.getIdLoja(id);
        return parceiros.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(parceiros);
    }

    @PostMapping
    public ResponseEntity post(@RequestBody Parceiro parceiro) {
        ParceiroDTO c = service.insert(parceiro);
        URI location = getUri(c.getId());
        return ResponseEntity.created(location).body(c);
    }

    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }

    @PutMapping("/{cidade}")
    public ResponseEntity put(@PathVariable("cidade") Long cidade, @RequestBody Parceiro pontuacao) {

        pontuacao.setCidade(cidade);

        ParceiroDTO c = service.update(pontuacao, cidade);

        return c != null ?
                ResponseEntity.ok(c) :
                ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
