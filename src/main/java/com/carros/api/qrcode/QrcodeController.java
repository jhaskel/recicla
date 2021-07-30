package com.carros.api.qrcode;

import com.carros.api.logistica.Logistica;
import com.carros.api.logistica.LogisticaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/qrcode")
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



    @GetMapping("loja/{idloja}")
    public ResponseEntity getExtratoByIdloja(@PathVariable("idloja") Long idloja) {
        List<QrcodeDTO> pontuacaos = service.getExtratoByIdloja(idloja);
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

    @GetMapping("qr/{qrcode}")
    public ResponseEntity getQr(@PathVariable("qrcode") String qrcode) {
        List<QrcodeDTO> pontuacaos = service.getQrcode(qrcode);
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

    @PutMapping("/{id}")
    public ResponseEntity put(@PathVariable("id") Long id, @RequestBody Qrcode pontuacao) {

        pontuacao.setIdloja(id);

        QrcodeDTO c = service.update(pontuacao, id);

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
