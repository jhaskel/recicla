package com.carros.api.apoiadoresAnuncio;

import com.carros.api.infra.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ApoiadoresAnuncioService {

    @Autowired
    private ApoiadoresAnuncioRepository rep;

    public List<ApoiadoresAnuncioDTO> getAnuncio() {
        return rep.findAll().stream().map(ApoiadoresAnuncioDTO::create).collect(Collectors.toList());
    }

    public ApoiadoresAnuncioDTO getAnuncioById(Long id) {
        Optional<ApoiadoresAnuncio> bairro = rep.findById(id);
        return bairro.map(ApoiadoresAnuncioDTO::create).orElseThrow(() -> new ObjectNotFoundException("Anuncio não encontrada"));
    }


    public List<ApoiadoresAnuncioDTO> getByAplicativo(Long aplicativo) {
        return rep.findByAplicativo(aplicativo).stream().map(ApoiadoresAnuncioDTO::create).collect(Collectors.toList());

    }
}