package com.carros.api.cupomMeus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/cuponsmeus")
public class CupomMeusController {
    @Autowired
    private CupomMeusService service;

    @GetMapping()
    public ResponseEntity get() {
        List<CupomMeusDTO> pontuacaos = service.getPontuacaos();
        return ResponseEntity.ok(pontuacaos);

    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        CupomMeusDTO pontuacao = service.getPontuacaoById(id);
        return ResponseEntity.ok(pontuacao);
    }

    @GetMapping("extrato/{usuario}")
    public ResponseEntity getExtratoByUsuario(@PathVariable("usuario") Long usuario) {
        List<CupomMeusDTO> pontuacaos = service.getExtratoByUsuario(usuario);
        return pontuacaos.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(pontuacaos);
    }

    @GetMapping("loja/{idloja}")
    public ResponseEntity getExtratoByIdloja(@PathVariable("idloja") Long idloja) {
        List<CupomMeusDTO> pontuacaos = service.getExtratoByIdloja(idloja);
        return pontuacaos.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(pontuacaos);
    }

    @GetMapping("qrcode/{codigo}")
    public ResponseEntity getExtratoByCodigo(@PathVariable("codigo") String codigo) {
        List<CupomMeusDTO> pontuacaos = service.getExtratoByCodigo(codigo);
        return pontuacaos.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(pontuacaos);
    }

    @GetMapping("usuario/{usuario}/{tipo}")
    public ResponseEntity getCupomByUsuario(@PathVariable("usuario") Long usuario,@PathVariable("tipo") String tipo) {
        List<CupomMeusDTO> pontuacaos = service.getCupomByUsuario(usuario,tipo);
        return pontuacaos.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(pontuacaos);
    }



    @PostMapping
    public ResponseEntity post(@RequestBody CupomMeus pontuacao) {

        CupomMeusDTO c = service.insert(pontuacao);

        URI location = getUri(c.getId());
        return ResponseEntity.created(location).body(c);
    }

    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }

    @PutMapping("/{usuario}")
    public ResponseEntity put(@PathVariable("usuario") Long usuario, @RequestBody CupomMeus pontuacao) {

        pontuacao.setUsuario(usuario);

        CupomMeusDTO c = service.update(pontuacao, usuario);

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
