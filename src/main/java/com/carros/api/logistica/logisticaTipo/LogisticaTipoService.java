package com.carros.api.logistica.logisticaTipo;

import com.carros.api.infra.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LogisticaTipoService {

    @Autowired
    private LogisticaTipoRepository rep;

    public List<LogisticaTipoDTO> getClasse() {
        return rep.findAll().stream().map(LogisticaTipoDTO::create).collect(Collectors.toList());
    }

    public LogisticaTipoDTO getClasseById(Long id) {
        Optional<LogisticaTipo> classe = rep.findById(id);
        return classe.map(LogisticaTipoDTO::create).orElseThrow(() -> new ObjectNotFoundException("Carro não encontrado"));
    }

    public List<LogisticaTipoDTO> getAll(Long id) {
        return rep.findAlla(id).stream().map(LogisticaTipoDTO::create).collect(Collectors.toList());
    }


    public LogisticaTipoDTO insert(LogisticaTipo pontuacao) {
        Assert.isNull(pontuacao.getId(),"Não foi possível inserir o registro");
        return LogisticaTipoDTO.create(rep.save(pontuacao));
    }


    public LogisticaTipoDTO update(LogisticaTipo pontuacao, Long usuario) {
        Assert.notNull(usuario,"Não foi possível atualizar o registro");

        // Busca o carro no banco de dados
        Optional<LogisticaTipo> optional = rep.findById(usuario);
        if(optional.isPresent()) {
            LogisticaTipo db = optional.get();
            // Copiar as propriedades
            db.setNome(pontuacao.getNome());
            System.out.println("Pontuacao id " + db.getId());

            // Atualiza a pontuacao
            rep.save(db);

            return LogisticaTipoDTO.create(db);
        } else {
            return null;
            //throw new RuntimeException("Não foi possível atualizar o registro");
        }
    }

    public void delete(Long id) {
        rep.deleteById(id);
    }
}