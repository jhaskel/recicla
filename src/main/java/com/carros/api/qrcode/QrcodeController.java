package com.carros.api.qrcode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/cuponsmeus")
public class QrcodeController {
    @Autowired
    private QrcodeService service;

    @GetMapping()
    public ResponseEntity get() {
        List<QrcodeDTO> pontuacaos = service.getPontuacaos();
        return ResponseEntity.ok(pontuacaos);

    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        QrcodeDTO pontuacao = service.getPontuacaoById(id);
        return ResponseEntity.ok(pontuacao);
    }

    @GetMapping("extrato/{usuario}")
    public ResponseEntity getExtratoByUsuario(@PathVariable("usuario") Long usuario) {
        List<QrcodeDTO> pontuacaos = service.getExtratoByUsuario(usuario);
        return pontuacaos.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(pontuacaos);
    }

    @GetMapping("loja/{idloja}")
    public ResponseEntity getExtratoByIdloja(@PathVariable("idloja") Long idloja) {
        List<QrcodeDTO> pontuacaos = service.getExtratoByIdloja(idloja);
        return pontuacaos.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(pontuacaos);
    }

    @GetMapping("qrcode/{codigo}")
    public ResponseEntity getExtratoByCodigo(@PathVariable("codigo") String codigo) {
        List<QrcodeDTO> pontuacaos = service.getExtratoByCodigo(codigo);
        return pontuacaos.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(pontuacaos);
    }

    @GetMapping("usuario/{usuario}/{tipo}")
    public ResponseEntity getCupomByUsuario(@PathVariable("usuario") Long usuario,@PathVariable("tipo") String tipo) {
        List<QrcodeDTO> pontuacaos = service.getCupomByUsuario(usuario,tipo);
        return pontuacaos.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(pontuacaos);
    }



    @PostMapping
    public ResponseEntity post(@RequestBody Qrcode pontuacao) {

        QrcodeDTO c = service.insert(pontuacao);

        URI location = getUri(c.getId());
        return ResponseEntity.created(location).body(c);
    }

    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }

    @PutMapping("/{usuario}")
    public ResponseEntity put(@PathVariable("usuario") Long usuario, @RequestBody Qrcode pontuacao) {

        pontuacao.setUsuario(usuario);

        QrcodeDTO c = service.update(pontuacao, usuario);

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
