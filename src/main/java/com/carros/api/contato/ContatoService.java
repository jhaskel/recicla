package com.carros.api.contato;

import com.carros.api.infra.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository rep;


    public List<ContatoDTO> getContatos() {
        return rep.findAllContatos().stream().map(ContatoDTO::create).collect(Collectors.toList());
    }


    public ContatoDTO getPontuacaoById(Long id) {
        Optional<Contato> pontuacao = rep.findById(id);
        return pontuacao.map(ContatoDTO::create).orElseThrow(() -> new ObjectNotFoundException("Pontuacao não encontrado"));
    }
    public List<ContatoDTO> getContatoBySetor(Long setor) {
        return rep.findContatoBySetor(setor).stream().map(ContatoDTO::create).collect(Collectors.toList());
    }


    public List<ContatoDTO> getContatoByCidade(Long cidade) {
        return rep.findContatoByCidade(cidade).stream().map(ContatoDTO::create).collect(Collectors.toList());
    }



    public ContatoDTO insert(Contato pontuacao) {
        Assert.isNull(pontuacao.getId(),"Não foi possível inserir o registro");
        return ContatoDTO.create(rep.save(pontuacao));
    }

    public ContatoDTO update(Contato pontuacao, Long usuario) {
        Assert.notNull(usuario,"Não foi possível atualizar o registro");

        // Busca o carro no banco de dados
        Optional<Contato> optional = rep.findById(usuario);
        if(optional.isPresent()) {
            Contato db = optional.get();
            // Copiar as propriedades
            db.setUsuario(pontuacao.getUsuario());
            db.setAssunto(pontuacao.getAssunto());
            db.setUsuario(pontuacao.getUsuario());
            db.setAno(pontuacao.getAno());
       //     System.out.println("Pontuacao id " + db.getId());

            // Atualiza a pontuacao
            rep.save(db);

            return ContatoDTO.create(db);
        } else {
            return null;
            //throw new RuntimeException("Não foi possível atualizar o registro");
        }
    }

    public void delete(Long id) {
        rep.deleteById(id);
    }


}
