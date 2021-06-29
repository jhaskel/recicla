package com.carros.api.caminhao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/caminhao")

public class CaminhaoController {
    @Autowired
    private CaminhaoService service;


    @GetMapping()
    public ResponseEntity get() {
        List<CaminhaoDTO> caminhaos = service.getCaminhaos();
        return ResponseEntity.ok(caminhaos);
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        CaminhaoDTO caminhao = service.getCaminhaoById(id);

        return ResponseEntity.ok(caminhao);
    }

    @GetMapping("/empresa/{idempresa}")
    public ResponseEntity getCaminhaoByIdEmpresa(@PathVariable("idempresa") Long idempresa) {
        List<CaminhaoDTO> coletando = service.getCaminhaoByIdEmpresa(idempresa);
        return coletando.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(coletando);
    }


    @PostMapping

    public ResponseEntity post(@RequestBody Caminhao caminhao) {

        CaminhaoDTO c = service.insert(caminhao);

        URI location = getUri(c.getId());
        return ResponseEntity.created(location).body(c);
    }

    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }

    @PutMapping("/{id}")
    public ResponseEntity put(@PathVariable("id") Long id, @RequestBody Caminhao caminhao) {

        caminhao.setId(id);

        CaminhaoDTO c = service.update(caminhao, id);

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
