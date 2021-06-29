package com.carros.api.logistica.logisticaResiduo;

import com.carros.api.infra.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LogisticaResiduoService {

    @Autowired
    private LogisticaResiduoRepository rep;

    public List<LogisticaResiduoDTO> getClasse() {
        return rep.findAll().stream().map(LogisticaResiduoDTO::create).collect(Collectors.toList());
    }

    public LogisticaResiduoDTO getClasseById(Long id) {
        Optional<LogisticaResiduo> classe = rep.findById(id);
        return classe.map(LogisticaResiduoDTO::create).orElseThrow(() -> new ObjectNotFoundException("Carro não encontrado"));
    }



    public List<LogisticaResiduoDTO> getAll(Long id) {
        return rep.findAlla(id).stream().map(LogisticaResiduoDTO::create).collect(Collectors.toList());
    }

    public List<LogisticaResiduoDTO> getAlll() {
        return rep.findAlll().stream().map(LogisticaResiduoDTO::create).collect(Collectors.toList());
    }


    public List<LogisticaResiduoDTO> getLogisticaByNome(Long cidade,String nome) {
        return rep.findLogisticaByNome(cidade,nome).stream().map(LogisticaResiduoDTO::create).collect(Collectors.toList());
    }


    public LogisticaResiduoDTO insert(LogisticaResiduo pontuacao) {
        Assert.isNull(pontuacao.getId(),"Não foi possível inserir o registro");
        return LogisticaResiduoDTO.create(rep.save(pontuacao));
    }


    public LogisticaResiduoDTO update(LogisticaResiduo pontuacao, Long usuario) {
        Assert.notNull(usuario,"Não foi possível atualizar o registro");

        // Busca o carro no banco de dados
        Optional<LogisticaResiduo> optional = rep.findById(usuario);
        if(optional.isPresent()) {
            LogisticaResiduo db = optional.get();
            // Copiar as propriedades
            db.setNome(pontuacao.getNome());
            System.out.println("Pontuacao id " + db.getId());

            // Atualiza a pontuacao
            rep.save(db);

            return LogisticaResiduoDTO.create(db);
        } else {
            return null;
            //throw new RuntimeException("Não foi possível atualizar o registro");
        }
    }

    public void delete(Long id) {
        rep.deleteById(id);
    }
}