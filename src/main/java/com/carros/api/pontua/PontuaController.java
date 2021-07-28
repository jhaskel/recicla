package com.carros.api.pontua;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/pontua")
public class PontuaController {
    @Autowired
    private PontuaService service;

    @GetMapping()
    public ResponseEntity get() {
        List<PontuaDTO> pontuacaos = service.getPontuacaos();
        return ResponseEntity.ok(pontuacaos);

    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        PontuaDTO pontuacao = service.getPontuacaoById(id);
        return ResponseEntity.ok(pontuacao);
    }

    @GetMapping("extrato/{usuario}")
    public ResponseEntity getExtratoByUsuario(@PathVariable("usuario") Long usuario) {
        List<PontuaDTO> pontuacaos = service.getExtratoByUsuario(usuario);
        return pontuacaos.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(pontuacaos);
    }





    //verifica se o usuario ja fez brique no mes
    @GetMapping("/brique/{usuario}/{ano}/{mes}")
    public Long getPontosMes(@PathVariable("usuario") Long usuario,@PathVariable("ano") Long ano,@PathVariable("mes") Long mes) {
        return service.getPontosMes(usuario,ano,mes);
    }





    @PostMapping
    public ResponseEntity post(@RequestBody Pontua pontuacao) {

        PontuaDTO c = service.insert(pontuacao);

        URI location = getUri(c.getId());
        return ResponseEntity.created(location).body(c);
    }

    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }

    @PutMapping("/{usuario}")
    public ResponseEntity put(@PathVariable("usuario") Long usuario, @RequestBody Pontua pontuacao) {

        pontuacao.setUsuario(usuario);

        PontuaDTO c = service.update(pontuacao, usuario);

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
