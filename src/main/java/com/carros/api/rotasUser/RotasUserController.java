package com.carros.api.rotasUser;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/rotausers")
public class RotasUserController {
    @Autowired
    private RotasUserService service;

    @GetMapping()
    public ResponseEntity get() {
        List<RotasUserDTO> RotasUsers = service.getRotasUsers();
        return ResponseEntity.ok(RotasUsers);
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        RotasUserDTO RotasUser = service.getRotasUserById(id);

        return ResponseEntity.ok(RotasUser);
    }
    @GetMapping("user/{user}")
    public ResponseEntity getRotasByUser(@PathVariable("user") Long user) {
        List<RotasUserDTO> pontuacaos = service.getERotaByUser(user);
        return pontuacaos.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(pontuacaos);
    }


    @PostMapping
    @Secured({ "ROLE_ADMIN" })
    public ResponseEntity post(@RequestBody RotasUser RotasUser) {

        RotasUserDTO c = service.insert(RotasUser);

        URI location = getUri(c.getId());
        return ResponseEntity.created(location).body(c);
    }

    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }

    @PutMapping("/{id}")
    public ResponseEntity put(@PathVariable("id") Long id, @RequestBody RotasUser RotasUser) {

        RotasUser.setId(id);

        RotasUserDTO c = service.update(RotasUser, id);

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
