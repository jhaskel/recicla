package com.carros.api.parceiro.parceiroCupons;

import com.carros.api.infra.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ParceiroCuponsService {

    @Autowired
    private ParceiroCuponsRepository rep;


    public List<ParceiroCuponsDTO> getPontuacaos() {
        return rep.findAll().stream().map(ParceiroCuponsDTO::create).collect(Collectors.toList());

    }

    public ParceiroCuponsDTO getPontuacaoById(Long id) {
        Optional<ParceiroCupons> pontuacao = rep.findById(id);
        return pontuacao.map(ParceiroCuponsDTO::create).orElseThrow(() -> new ObjectNotFoundException("Pontuacao não encontrado"));
    }


    public List<ParceiroCuponsDTO> getParceiroByIdloja(Long idloja) {
        return rep.findParceiroByIdloja(idloja).stream().map(ParceiroCuponsDTO::create).collect(Collectors.toList());
    }


    public List<ParceiroCuponsDTO> getCidade(Long cidade) {
        return rep.findCidade(cidade).stream().map(ParceiroCuponsDTO::create).collect(Collectors.toList());
    }





    public ParceiroCuponsDTO insert(ParceiroCupons pontuacao) {
        Assert.isNull(pontuacao.getId(),"Não foi possível inserir o registro");
        return ParceiroCuponsDTO.create(rep.save(pontuacao));
    }

    public ParceiroCuponsDTO update(ParceiroCupons pontuacao, Long id) {
        Assert.notNull(id,"Não foi possível atualizar o registro");

        // Busca o carro no banco de dados
        Optional<ParceiroCupons> optional = rep.findById(id);
        if(optional.isPresent()) {
            ParceiroCupons db = optional.get();
            // Copiar as propriedades
            db.setQuantidade(pontuacao.getQuantidade());
            db.setAtivo(pontuacao.getAtivo());
            db.setTitulo(pontuacao.getTitulo());
            db.setObservacao(pontuacao.getObservacao());
            db.setEstoque(pontuacao.getEstoque());
            db.setHorario(pontuacao.getHorario());
            db.setValor(pontuacao.getValor());
            db.setQuantidade(pontuacao.getQuantidade());
            db.setProdutos(pontuacao.getProdutos());
            db.setImagem(pontuacao.getImagem());
            db.setIsonline(pontuacao.getIsonline());
            db.setPatrocinador(pontuacao.getPatrocinador());
            db.setObservacao(pontuacao.getObservacao());
            db.setDesconto(pontuacao.getDesconto());
            db.setProdutos(pontuacao.getProdutos());
            db.setTipo(pontuacao.getTipo());
            db.setTipocupom(pontuacao.getTipocupom());
            db.setNomeloja(pontuacao.getNomeloja());


       //     System.out.println("Pontuacao id " + db.getId());

            // Atualiza a pontuacao
            rep.save(db);

            return ParceiroCuponsDTO.create(db);
        } else {
            return null;
            //throw new RuntimeException("Não foi possível atualizar o registro");
        }
    }

    public void delete(Long id) {
        rep.deleteById(id);
    }


}
