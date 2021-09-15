package com.carros.api.parceiro.parceiroCupons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/parceirocupons")
public class ParceiroCuponsController {
    @Autowired
    private ParceiroCuponsService service;

    @GetMapping()
    public ResponseEntity get() {
        List<ParceiroCuponsDTO> pontuacaos = service.getPontuacaos();
        return ResponseEntity.ok(pontuacaos);

    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        ParceiroCuponsDTO pontuacao = service.getPontuacaoById(id);
        return ResponseEntity.ok(pontuacao);
    }

    @GetMapping("loja/{idloja}")
    public ResponseEntity getParceiroByIdloja(@PathVariable("idloja") Long idloja) {
        List<ParceiroCuponsDTO> parceiros = service.getParceiroByIdloja(idloja);
        return parceiros.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(parceiros);
    }
    @GetMapping("cidade/{cidade}")
    public ResponseEntity getCidade(@PathVariable("cidade") Long cidade) {
        List<ParceiroCuponsDTO> parceiros = service.getCidade(cidade);
        return parceiros.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(parceiros);
    }



    @PostMapping
    public ResponseEntity post(@RequestBody ParceiroCupons pontuacao) {

        ParceiroCuponsDTO c = service.insert(pontuacao);

        URI location = getUri(c.getId());
        return ResponseEntity.created(location).body(c);
    }

    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }

    @PutMapping("/{id}")
    public ResponseEntity put(@PathVariable("id") Long id, @RequestBody ParceiroCupons pontuacao) {

        pontuacao.setIdloja(id);

        ParceiroCuponsDTO c = service.update(pontuacao, id);

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
