package com.carros.api.imprevistos;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/imprevistos")
public class ImprevistosController {
    @Autowired
    private ImprevistosService service;



    @GetMapping()
    public ResponseEntity get() {
        List<ImprevistosDTO> imprevistos = service.getImprevistos();
        return ResponseEntity.ok(imprevistos);
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        ImprevistosDTO imprevisto = service.getImprevistoById(id);

        return ResponseEntity.ok(imprevisto);
    }

    @GetMapping("/dia/{dia}/{coleta}")
    public ResponseEntity getImprevistoByDia(@PathVariable("dia") String dia,@PathVariable("coleta") Long coleta) {
        List<ImprevistosDTO> imprevisto = service.getImprevistoByColeta(dia,coleta);
        return imprevisto.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(imprevisto);
    }


    @PostMapping

    public ResponseEntity post(@RequestBody Imprevistos imprevisto) {

        ImprevistosDTO c = service.insert(imprevisto);

        URI location = getUri(c.getId());
        return ResponseEntity.created(location).body(c);
    }

    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }

    @PutMapping("/{id}")
    public ResponseEntity put(@PathVariable("id") Long id, @RequestBody Imprevistos imprevisto) {

        imprevisto.setId(id);

        ImprevistosDTO c = service.update(imprevisto, id);

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
