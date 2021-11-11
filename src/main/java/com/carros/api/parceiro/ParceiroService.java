package com.carros.api.parceiro;

import com.carros.api.infra.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ParceiroService {

    @Autowired
    private ParceiroRepository rep;


    public List<ParceiroDTO> getPontuacaos() {
        return rep.findAll().stream().map(ParceiroDTO::create).collect(Collectors.toList());

    }

    public ParceiroDTO getPontuacaoById(Long id) {
        Optional<Parceiro> pontuacao = rep.findById(id);
        return pontuacao.map(ParceiroDTO::create).orElseThrow(() -> new ObjectNotFoundException("Pontuacao não encontrado"));
    }


    public List<ParceiroDTO> getParceiroByCidade(Long cidade) {
        return rep.findParceiroByCidade(cidade).stream().map(ParceiroDTO::create).collect(Collectors.toList());
    }


    public List<ParceiroDTO> getParceiroById(Long id) {
        return rep.findParceiroById(id).stream().map(ParceiroDTO::create).collect(Collectors.toList());
    }

    public List<ParceiroDTO> getIdLoja(Long id) {
        return rep.findIdLoja(id).stream().map(ParceiroDTO::create).collect(Collectors.toList());
    }


    public ParceiroDTO insert(Parceiro parceiro) {
        Assert.isNull(parceiro.getId(),"Não foi possível inserir o registro");
        return ParceiroDTO.create(rep.save(parceiro));
    }

    public ParceiroDTO update(Parceiro pontuacao, Long usuario) {
        Assert.notNull(usuario,"Não foi possível atualizar o registro");

        // Busca o carro no banco de dados
        Optional<Parceiro> optional = rep.findById(usuario);
        if(optional.isPresent()) {
            Parceiro db = optional.get();
            // Copiar as propriedades
           // db.setAtivo(pontuacao.getAtivo());
          //  db.setContent(pontuacao.getContent());

           // db.setContent(pontuacao.getContent());
       //     System.out.println("Pontuacao id " + db.getId());

            // Atualiza a pontuacao
            rep.save(db);

            return ParceiroDTO.create(db);
        } else {
            return null;
            //throw new RuntimeException("Não foi possível atualizar o registro");
        }
    }

    public void delete(Long id) {
        rep.deleteById(id);
    }



}
