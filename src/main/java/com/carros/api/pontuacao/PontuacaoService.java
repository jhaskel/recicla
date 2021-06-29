package com.carros.api.pontuacao;

import com.carros.api.infra.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PontuacaoService {

    @Autowired
    private PontuacaoRepository rep;





    public PontuacaoDTO insert(Pontuacao pontuacao) {
        Assert.isNull(pontuacao.getId(),"Não foi possível inserir o registro");
        return PontuacaoDTO.create(rep.save(pontuacao));
    }

    public PontuacaoDTO update(Pontuacao pontuacao, Long usuario) {
        Assert.notNull(usuario,"Não foi possível atualizar o registro");

        // Busca o carro no banco de dados
        Optional<Pontuacao> optional = rep.findById(usuario);
        if(optional.isPresent()) {
            Pontuacao db = optional.get();
            // Copiar as propriedades
            db.setEcoins(pontuacao.getEcoins());
            db.setPontos(pontuacao.getPontos());
            db.setUsuario(pontuacao.getUsuario());
            db.setAno(pontuacao.getAno());
       //     System.out.println("Pontuacao id " + db.getId());

            // Atualiza a pontuacao
            rep.save(db);

            return PontuacaoDTO.create(db);
        } else {
            return null;
            //throw new RuntimeException("Não foi possível atualizar o registro");
        }
    }

    public void delete(Long id) {
        rep.deleteById(id);
    }




    public double getRe(Long usuario, Long ano){
        return rep.findSoma(usuario,ano);
    }


    public double getRepMes(Long usuario, Long ano ,Long mes){
        return rep.findSomaMes(usuario,ano,mes);
    }

    public List<PontuacaoDTO> getPontuacaoByAno(Long ano) {
        return rep.findByAno(ano).stream().map(PontuacaoDTO::create).collect(Collectors.toList());
    }

    public List<PontuacaoDTO> getPontuacaoByMes(Long ano,Long mes) {
        return rep.findByMes(ano,mes).stream().map(PontuacaoDTO::create).collect(Collectors.toList());
    }

    public double getPontosRe(Long usuario, Long ano) {
        return rep.findPontoSoma(usuario,ano);
    }

    public double getPontosTotal(Long usuario) {
        return rep.findPontoTotal(usuario);
    }

    public double getPontosMes(Long usuario, Long ano, Long mes) {
        return rep.findPontosMes(usuario,ano,mes);
    }

    public List<PontuacaoDTO> getPontuacaoPontosByAno(Long ano,Long cidade) {
        return rep.findPontosByAno(ano,cidade).stream().map(PontuacaoDTO::create).collect(Collectors.toList());
    }


    public List<PontuacaoDTO> getPontuacaoPontos() {
        return rep.findPontos().stream().map(PontuacaoDTO::create).collect(Collectors.toList());

    }


    public List<PontuacaoDTO> getPontuacaoPontosByMes(Long ano, Long mes,Long cidade) {
        return rep.findPontosByMes(ano,mes,cidade).stream().map(PontuacaoDTO::create).collect(Collectors.toList());
    }

    public List<PontuacaoDTO> getPontuacaoBySemana(Long ano, Long semana) {
        return rep.findEcoinsBySemana(ano,semana).stream().map(PontuacaoDTO::create).collect(Collectors.toList());
    }

    public List<PontuacaoDTO> getPontuacaoPontosBySemana(Long ano, Long semana,Long cidade) {
        return rep.findPontosBySemana(ano,semana,cidade).stream().map(PontuacaoDTO::create).collect(Collectors.toList());
    }
}
