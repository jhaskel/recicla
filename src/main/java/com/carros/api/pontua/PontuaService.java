package com.carros.api.pontua;

import com.carros.api.infra.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PontuaService {

    @Autowired
    private PontuaRepository rep;


    public List<PontuaDTO> getPontuacaos() {
        return rep.findAll().stream().map(PontuaDTO::create).collect(Collectors.toList());

    }

    public PontuaDTO getPontuacaoById(Long id) {
        Optional<Pontua> pontuacao = rep.findById(id);
        return pontuacao.map(PontuaDTO::create).orElseThrow(() -> new ObjectNotFoundException("Pontuacao não encontrado"));
    }


    public List<PontuaDTO> getExtratoByUsuario(Long usuario) {
        return rep.findExtratoByUsuario(usuario).stream().map(PontuaDTO::create).collect(Collectors.toList());
    }


    public Long getPontosMes(Long usuario, Long ano, Long mes) {
        return rep.findPontosMes(usuario,ano,mes);
    }

    public PontuaDTO insert(Pontua pontuacao) {
        Assert.isNull(pontuacao.getId(),"Não foi possível inserir o registro");
        return PontuaDTO.create(rep.save(pontuacao));
    }

    public PontuaDTO update(Pontua pontuacao, Long usuario) {
        Assert.notNull(usuario,"Não foi possível atualizar o registro");

        // Busca o carro no banco de dados
        Optional<Pontua> optional = rep.findById(usuario);
        if(optional.isPresent()) {
            Pontua db = optional.get();
            // Copiar as propriedades
            db.setEcoins(pontuacao.getEcoins());
            db.setPontos(pontuacao.getPontos());
            db.setUsuario(pontuacao.getUsuario());
            db.setAno(pontuacao.getAno());
       //     System.out.println("Pontuacao id " + db.getId());

            // Atualiza a pontuacao
            rep.save(db);

            return PontuaDTO.create(db);
        } else {
            return null;
            //throw new RuntimeException("Não foi possível atualizar o registro");
        }
    }

    public void delete(Long id) {
        rep.deleteById(id);
    }



}
