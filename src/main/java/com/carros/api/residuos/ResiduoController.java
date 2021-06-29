package com.carros.api.residuos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/residuos")

public class ResiduoController {

    @Autowired
    private ResiduoService service;

    @GetMapping()
    public ResponseEntity get() {
        List<ResiduoDTO> residuos = service.getResiduo();
        return ResponseEntity.ok(residuos);
    }

    @GetMapping("/soma/{year}/{cidade}")
    public double getRe(@PathVariable("year") Long year,@PathVariable("cidade") Long cidade) {
        return service.getRe(year,cidade);
    }


    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        ResiduoDTO residuo = service.getResiduoById(id);
        return  ResponseEntity.ok(residuo);
    }


    @GetMapping("/tipo/{tipo}")
    public ResponseEntity getResiduoByTipo(@PathVariable("tipo") String tipo) {
        List<ResiduoDTO> residuos = service.getResiduoByTipo(tipo);
        return residuos.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(residuos);
    }


    @GetMapping("/year/{year}")
    public ResponseEntity getResiduoByYear(@PathVariable("year") Long year) {
        List<ResiduoDTO> residuos = service.getResiduoByYear(year);
        return residuos.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(residuos);
    }
    @GetMapping("/destino/{cidade}/{year}")
    public ResponseEntity getResiduoByDestino(@PathVariable("cidade") Long cidade,@PathVariable("year") Long year) {
        List<ResiduoDTO> residuos = service.getResiduoByDestino(cidade,year);
        return residuos.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(residuos);
    }

    @GetMapping("/{cidade}/{year}")
    public ResponseEntity getResiduoByCidade(@PathVariable("cidade") Long cidade,@PathVariable("year") Long year) {
        List<ResiduoDTO> residuos = service.getResiduoByCidade(cidade,year);
        return residuos.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(residuos);
    }

    @GetMapping("metas/{cidade}/{year}")
    public ResponseEntity getMetas(@PathVariable("cidade") Long cidade,@PathVariable("year") Long year) {
        List<ResiduoDTO> residuos = service.getMetas(cidade,year);
        return residuos.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(residuos);
    }

    @GetMapping("total/{year}")
    public ResponseEntity getResiduoByCidadeTotal(@PathVariable("year") Long year) {
        ResiduoDTO residuo = service.getResiduoByCidadeTotal(year);
        return  ResponseEntity.ok(residuo);
    }

    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }

}
