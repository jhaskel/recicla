package com.carros.api.pontuacao;

import com.carros.api.pontua.PontuaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/pontuacao")
public class PontuacaoController {
    @Autowired
    private PontuacaoService service;


    /*  ECOINS */
   //calcula o total de pontos por ano de um determinado usuario
    @GetMapping("/ecoins/userano/{usuario}/{ano}")
    public double getRep(@PathVariable("usuario") Long usuario,@PathVariable("ano") Long ano) {
        return service.getRe(usuario,ano);
    }

    //calcula o total por mes de um determinado usuario
    @GetMapping("/ecoins/usermes/{usuario}/{ano}/{mes}")
    public double getRepMes(@PathVariable("usuario") Long usuario,@PathVariable("ano") Long ano,@PathVariable("mes") Long mes) {
        return service.getRepMes(usuario,ano,mes);
    }



    //retorna ranking de ecoins por ano
    @GetMapping("ecoins/{ano}")
    public ResponseEntity getPontuacaoByAno(@PathVariable("ano") Long ano) {
        List<PontuacaoDTO> pontuacaos = service.getPontuacaoByAno(ano);
        return pontuacaos.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(pontuacaos);
    }


     //retorna a lista rankiada de ecoins  por mes
    @GetMapping("/ecoinsmes/{ano}/{mes}")
    public ResponseEntity getPontuacaoByMes(@PathVariable("ano") Long ano,@PathVariable("mes") Long mes) {
        List<PontuacaoDTO> pontuacaos = service.getPontuacaoByMes(ano,mes);
        return pontuacaos.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(pontuacaos);
    }

    //retorna a lista rankiada de ecoins  por semana
    @GetMapping("/ecoinssemana/{ano}/{semana}")
    public ResponseEntity getPontuacaoBySemana(@PathVariable("ano") Long ano,@PathVariable("semana") Long semana) {
        List<PontuacaoDTO> pontuacaos = service.getPontuacaoBySemana(ano,semana);
        return pontuacaos.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(pontuacaos);
    }

    /*  ECOINS FIM */


    /* PONTOS INICIO*/

    //calcula o total de pontos  de um determinado usuario
    @GetMapping("/pontos/user/{usuario}")
    public double getPontosTotalRep(@PathVariable("usuario") Long usuario) {
        return service.getPontosTotal(usuario);
    }

    //calcula o total de pontos por ano de um determinado usuario
    @GetMapping("/pontos/userano/{usuario}/{ano}")
    public double getPontosRep(@PathVariable("usuario") Long usuario,@PathVariable("ano") Long ano) {
        return service.getPontosRe(usuario,ano);
    }
    //calcula o total de pontos por mes de um determinado usuario
    @GetMapping("/pontos/usermes/{usuario}/{ano}/{mes}")
    public double getPontosMes(@PathVariable("usuario") Long usuario,@PathVariable("ano") Long ano,@PathVariable("mes") Long mes) {
        return service.getPontosMes(usuario,ano,mes);
    }

    @GetMapping("extrato/{usuario}")
    public ResponseEntity getExtratoByUsuario(@PathVariable("usuario") Long usuario) {
        List<PontuaDTO> pontuacaos = service.getExtratoByUsuario(usuario);
        return pontuacaos.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(pontuacaos);
    }


    //retorna ranking de pontos
    @GetMapping("/pontos")
    public ResponseEntity getPontuacaoPontos() {
        List<PontuacaoDTO> pontuacaos = service.getPontuacaoPontos();
        return pontuacaos.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(pontuacaos);
    }

    //retorna ranking de pontos por ano de uma cidade
    @GetMapping("/pontos/{ano}/{cidade}")
    public ResponseEntity getPontuacaoPontosByAno(@PathVariable("ano") Long ano,@PathVariable("cidade") Long cidade) {
        List<PontuacaoDTO> pontuacaos = service.getPontuacaoPontosByAno(ano,cidade);
        return pontuacaos.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(pontuacaos);
    }


    //retorna a lista rankiada de pontos  por mes
    @GetMapping("/pontosmes/{ano}/{mes}/{cidade}")
    public ResponseEntity getPontuacaoPontosByMes(@PathVariable("ano") Long ano,@PathVariable("mes") Long mes,@PathVariable("cidade") Long cidade) {
        List<PontuacaoDTO> pontuacaos = service.getPontuacaoPontosByMes(ano,mes,cidade);
        return pontuacaos.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(pontuacaos);
    }
    //retorna a lista rankiada de pontos  por semana
    @GetMapping("/pontossemana/{ano}/{semana}/{cidade}")
    public ResponseEntity getPontuacaoPontosBySemana(@PathVariable("ano") Long ano,@PathVariable("semana") Long semana,@PathVariable("cidade") Long cidade) {
        List<PontuacaoDTO> pontuacaos = service.getPontuacaoPontosBySemana(ano,semana,cidade);
        return pontuacaos.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(pontuacaos);
    }

    /* PONTOS FIM*/


    @PostMapping
    public ResponseEntity post(@RequestBody Pontuacao pontuacao) {

        PontuacaoDTO c = service.insert(pontuacao);

        URI location = getUri(c.getId());
        return ResponseEntity.created(location).body(c);
    }

    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }

    @PutMapping("/{usuario}")
    public ResponseEntity put(@PathVariable("usuario") Long usuario, @RequestBody Pontuacao pontuacao) {

        pontuacao.setUsuario(usuario);

        PontuacaoDTO c = service.update(pontuacao, usuario);

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
