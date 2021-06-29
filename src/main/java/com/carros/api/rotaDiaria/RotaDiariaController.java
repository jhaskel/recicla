package com.carros.api.rotaDiaria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/rotadiaria")
public class RotaDiariaController {
    @Autowired
    private RotaDiariaService service;

    @GetMapping()
    public ResponseEntity get() {
        List<RotaDiariaDTO> RotaDiarias = service.getRotaDiarias();
        return ResponseEntity.ok(RotaDiarias);
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        RotaDiariaDTO trajeto = service.getRotaDiariaById(id);

        return ResponseEntity.ok(trajeto);
    }
    @GetMapping("dia/{dia}")
    public ResponseEntity getRotaByDia(@PathVariable("dia") Long dia) {
        List<RotaDiariaDTO> pontuacaos = service.getRotaByDia(dia);
        return pontuacaos.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(pontuacaos);
    }

    @GetMapping("semana/{semana}/{ano}")
    public ResponseEntity getRotaBySemana(@PathVariable("semana") Long semana,@PathVariable("ano") Long ano) {
        List<RotaDiariaDTO> pontuacaos = service.getRotaBySemana(semana,ano);
        return pontuacaos.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(pontuacaos);
    }
    @GetMapping("rota/{idrota}")
    public ResponseEntity getRotaByIdrota(@PathVariable("idrota") Long idrota) {
        List<RotaDiariaDTO> pontuacaos = service.getRotaByIdrota(idrota);
        return pontuacaos.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(pontuacaos);
    }
    @GetMapping("mes/{mes}/{ano}")
    public ResponseEntity getRotaByMes(@PathVariable("mes") Long mes,@PathVariable("ano") Long ano) {
        List<RotaDiariaDTO> pontuacaos = service.getRotaByMes(mes,ano);
        return pontuacaos.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(pontuacaos);
    }
    @GetMapping("ano/{ano}")
    public ResponseEntity getRotaByAno(@PathVariable("ano") Long ano) {
        List<RotaDiariaDTO> pontuacaos = service.getRotaByAno(ano);
        return pontuacaos.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(pontuacaos);
    }
    @GetMapping("empresa/{idempresa}")
    public ResponseEntity getRotaByIdempresa(@PathVariable("idempresa") Long idempresa) {
        List<RotaDiariaDTO> pontuacaos = service.getRotaByIdempresa(idempresa);
        return pontuacaos.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(pontuacaos);
    }
    @GetMapping("caminhao/{idcaminhao}")
    public ResponseEntity getRotaByIdcaminhao(@PathVariable("idcaminhao") Long idcaminhao) {
        List<RotaDiariaDTO> pontuacaos = service.getRotaByIdcaminhao(idcaminhao);
        return pontuacaos.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(pontuacaos);
    }
    @GetMapping("usuario/{usuario}")
    public ResponseEntity getRotaByUsuario(@PathVariable("usuario") Long usuario) {
        List<RotaDiariaDTO> pontuacaos = service.getRotaByUsuario(usuario);
        return pontuacaos.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(pontuacaos);
    }
    @GetMapping("coleta/{idcoleta}")
    public ResponseEntity getRotaByIdcoleta(@PathVariable("idcoleta") Long idcoleta) {
        List<RotaDiariaDTO> pontuacaos = service.getRotaByIdcoleta(idcoleta);
        return pontuacaos.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(pontuacaos);
    }




    @PostMapping

    public ResponseEntity post(@RequestBody RotaDiaria trajeto) {

        RotaDiariaDTO c = service.insert(trajeto);

        URI location = getUri(c.getId());
        return ResponseEntity.created(location).body(c);
    }

    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }

    @PutMapping("/{id}")
    public ResponseEntity put(@PathVariable("id") Long id, @RequestBody RotaDiaria trajeto) {

        trajeto.setId(id);

        RotaDiariaDTO c = service.update(trajeto, id);

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
