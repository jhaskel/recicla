package com.carros.api.logistica;

import com.carros.api.infra.exception.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LogisticaService {

    @Autowired
    private LogisticaRepository rep;

    public List<LogisticaDTO> getClasse() {
        return rep.findAll().stream().map(LogisticaDTO::create).collect(Collectors.toList());
    }


    public LogisticaDTO getClasseById(Long id) {
        Optional<Logistica> classe = rep.findById(id);
        return classe.map(LogisticaDTO::create).orElseThrow(() -> new ObjectNotFoundException("Carro não encontrado"));
    }

    public List<LogisticaDTO> getLogisticaByCidade(Long cidade) {
        return rep.findLogisticaByCidade(cidade).stream().map(LogisticaDTO::create).collect(Collectors.toList());
    }
    public List<LogisticaDTO> getLogisticaByIdloja(Long idloja) {
        return rep.findLogisticaByIdLoja(idloja).stream().map(LogisticaDTO::create).collect(Collectors.toList());
    }

    public List<LogisticaDTO> getLogisticaByTipo(Long cidade,String tipo) {
        return rep.findLogisticaByTipo(cidade,tipo).stream().map(LogisticaDTO::create).collect(Collectors.toList());
    }
    public LogisticaDTO insert(Logistica pontuacao) {
        Assert.isNull(pontuacao.getId(),"Não foi possível inserir o registro");
        return LogisticaDTO.create(rep.save(pontuacao));
    }


    public LogisticaDTO update(Logistica pontuacao, Long usuario) {
        Assert.notNull(usuario,"Não foi possível atualizar o registro");

        // Busca o carro no banco de dados
        Optional<Logistica> optional = rep.findById(usuario);
        if(optional.isPresent()) {
            Logistica db = optional.get();
            // Copiar as propriedades
            db.setTipo(pontuacao.getTipo());
            db.setAtivo(pontuacao.getAtivo());
            db.setRetirar(pontuacao.getRetirar());
            System.out.println("Pontuacao id " + db.getId());

            // Atualiza a pontuacao
            rep.save(db);

            return LogisticaDTO.create(db);
        } else {
            return null;
            //throw new RuntimeException("Não foi possível atualizar o registro");
        }
    }

    public void delete(Long id) {
        rep.deleteById(id);
    }
}