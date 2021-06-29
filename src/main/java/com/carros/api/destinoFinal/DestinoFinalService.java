package com.carros.api.destinoFinal;

import com.carros.api.infra.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DestinoFinalService {
    @Autowired
    private DestinoFinalRepository rep;

    public List<DestinoFinalDTO> getDestinoFinal() {
        return rep.findAll().stream().map(DestinoFinalDTO::create).collect(Collectors.toList());
    }

    public DestinoFinalDTO getDestinoFinalById(Long id) {
        Optional<DestinoFinal> destinoFinal = rep.findById(id);
        return destinoFinal.map(DestinoFinalDTO::create).orElseThrow(() -> new ObjectNotFoundException("Destino não encontrado"));
    }

    public List<DestinoFinalDTO> getDestinoFinalByTitle(String title) {
        return rep.findByTitle(title).stream().map(DestinoFinalDTO::create).collect(Collectors.toList());
    }

}