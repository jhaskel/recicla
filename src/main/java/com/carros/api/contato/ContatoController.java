package com.carros.api.contato;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/contato")
public class ContatoController {
    @Autowired
    private ContatoService service;

    @GetMapping()
    public ResponseEntity get() {
        List<ContatoDTO> contato = service.getContatos();
        return ResponseEntity.ok(contato);
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        ContatoDTO pontuacao = service.getPontuacaoById(id);
        return ResponseEntity.ok(pontuacao);
    }

    @GetMapping("setor/{setor}")
    public ResponseEntity getContatoBySetor(@PathVariable("setor") Long setor) {
        List<ContatoDTO> contato = service.getContatoBySetor(setor);
        return contato.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(contato);
    }

    @GetMapping("cidade/{cidade}")
    public ResponseEntity getContatoByCidade(@PathVariable("cidade") Long cidade) {
        List<ContatoDTO> contato = service.getContatoByCidade(cidade);
        return contato.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(contato);
    }




    @PostMapping
    public ResponseEntity post(@RequestBody Contato pontuacao) {

        ContatoDTO c = service.insert(pontuacao);

        URI location = getUri(c.getId());
        return ResponseEntity.created(location).body(c);
    }

    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }

    @PutMapping("/{usuario}")
    public ResponseEntity put(@PathVariable("usuario") Long usuario, @RequestBody Contato pontuacao) {

        pontuacao.setUsuario(usuario);

        ContatoDTO c = service.update(pontuacao, usuario);

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
