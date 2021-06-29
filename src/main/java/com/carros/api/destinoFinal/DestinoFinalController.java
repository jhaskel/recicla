package com.carros.api.destinoFinal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/destinoFinal")
public class DestinoFinalController {
    @Autowired
    private DestinoFinalService service;

    @GetMapping()
    public ResponseEntity get() {
        List<DestinoFinalDTO> destinoFinal = service.getDestinoFinal();
        return ResponseEntity.ok(destinoFinal);
    }


    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        DestinoFinalDTO destinoFinal = service.getDestinoFinalById(id);
        return  ResponseEntity.ok(destinoFinal);

    }
    @GetMapping("/tipo/{title}")
    public ResponseEntity getDestinoFinalByTitle(@PathVariable("title") String title) {
        List<DestinoFinalDTO> destinoFinal = service.getDestinoFinalByTitle(title);
        return destinoFinal.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(destinoFinal);
    }


    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }


}
