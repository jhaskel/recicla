package com.carros.api.logistica;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/logistica")
public class LogisticaController {
    @Autowired
    private LogisticaService service;

    @GetMapping()
    public ResponseEntity get() {
        List<LogisticaDTO> dicas = service.getClasse();
        return ResponseEntity.ok(dicas);
    }


    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        LogisticaDTO dica = service.getClasseById(id);
        return  ResponseEntity.ok(dica);

    }

    @GetMapping("cidade/{cidade}")
    public ResponseEntity getLogisticaByCidade(@PathVariable("cidade") Long cidade) {
        List<LogisticaDTO> pontuacaos = service.getLogisticaByCidade(cidade);
        return pontuacaos.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(pontuacaos);
    }
    @GetMapping("loja/{idloja}")
    public ResponseEntity getLogisticaByIdloja(@PathVariable("idloja") Long idloja) {
        List<LogisticaDTO> pontuacaos = service.getLogisticaByIdloja(idloja);
        return pontuacaos.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(pontuacaos);
    }

    @GetMapping("tipo/{cidade}/{tipo}")
    public ResponseEntity getLogisticaByTipo(@PathVariable("cidade") Long cidade,@PathVariable("tipo") String tipo) {
        List<LogisticaDTO> pontuacaos = service.getLogisticaByTipo(cidade,tipo);
        return pontuacaos.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(pontuacaos);
    }


    @PostMapping
    public ResponseEntity post(@RequestBody Logistica pontuacao) {

        LogisticaDTO c = service.insert(pontuacao);

        URI location = getUri(c.getId());
        return ResponseEntity.created(location).body(c);
    }

    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }

    @PutMapping("/{id}")
    public ResponseEntity put(@PathVariable("id") Long id, @RequestBody Logistica pontuacao) {

        pontuacao.setIdloja(id);

        LogisticaDTO c = service.update(pontuacao, id);

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
