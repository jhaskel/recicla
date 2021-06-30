package com.carros.api.favoritos;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/favoritos")
public class FavoritosController {
    @Autowired
    private FavoritosService service;

    @GetMapping()
    public ResponseEntity get() {
        List<FavoritosDTO> rotas = service.getRotass();
        return ResponseEntity.ok(rotas);
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        FavoritosDTO rota = service.getRotasById(id);

        return ResponseEntity.ok(rota);
    }

    @GetMapping("/usuario/{usuario}/{icone}/{idevento}")
    public ResponseEntity getColetandoByCidade(@PathVariable("usuario") Long usuario,@PathVariable("icone") Long icone,@PathVariable("idevento") Long idevento) {
        List<FavoritosDTO> coletando = service.getRotasByCidade(usuario,icone,idevento);
        return coletando.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(coletando);
    }

    //verifica se tem favorito em postagem
    @GetMapping("/soma/{usuario}/{icone}/{idevento}")
    public double getRe(@PathVariable("usuario") Long usuario,@PathVariable("icone") Long icone,@PathVariable("idevento") Long idevento) {
        return service.getRe(usuario,icone,idevento);
    }
    //verifica se tem favorito em postagem
    @GetMapping("/quant/{usuario}/{icone}")
    public double getQuant(@PathVariable("usuario") Long usuario,@PathVariable("icone") Long icone) {
        return service.getQuant(usuario,icone);
    }

    @GetMapping("/briques/{usuario}/{icone}")
    public ResponseEntity getFavoritosByCidade(@PathVariable("usuario") Long usuario,@PathVariable("icone") Long icone) {
        List<FavoritosDTO> coletando = service.getRotasByIcone(usuario,icone);
        return coletando.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(coletando);
    }

    @GetMapping("/postar/{usuario}/{icone}/{idevento}")
    public ResponseEntity getFavoritosPostarByCidade(@PathVariable("usuario") Long usuario,@PathVariable("icone") Long icone,@PathVariable("idevento") Long idevento) {
        List<FavoritosDTO> coletando = service.getFavoritosPostarByIcone(usuario,icone,idevento);
        return coletando.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(coletando);
    }

    @GetMapping("/perfil/{usuario}/{icone}")
    public ResponseEntity getBriqueByIcone(@PathVariable("usuario") Long usuario,@PathVariable("icone") Long icone) {
        List<FavoritosDTO> coletando = service.getBriqueByIcone(usuario,icone);
        return coletando.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(coletando);
    }


    //calcula o total  dicas ou noticias lidas
    @GetMapping("quantLidas/{usuario}/{icone}")
    public Long getQuantLidas(@PathVariable("usuario") Long usuario,@PathVariable("icone") Long icone) {
        return service.getQuantLidas(usuario,icone);
    }





    @PostMapping

    public ResponseEntity post(@RequestBody Favoritos rota) {

        FavoritosDTO c = service.insert(rota);

        URI location = getUri(c.getId());
        return ResponseEntity.created(location).body(c);
    }

    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }

    @PutMapping("/{id}")
    public ResponseEntity put(@PathVariable("id") Long id, @RequestBody Favoritos rota) {

        rota.setId(id);

        FavoritosDTO c = service.update(rota, id);

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
