package com.carros.api.cupomMeus;

import com.carros.api.infra.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CupomMeusService {

    @Autowired
    private CupomMeusRepository rep;


    public List<CupomMeusDTO> getPontuacaos() {
        return rep.findAll().stream().map(CupomMeusDTO::create).collect(Collectors.toList());

    }

    public CupomMeusDTO getPontuacaoById(Long id) {
        Optional<CupomMeus> pontuacao = rep.findById(id);
        return pontuacao.map(CupomMeusDTO::create).orElseThrow(() -> new ObjectNotFoundException("Pontuacao não encontrado"));
    }


    public List<CupomMeusDTO> getExtratoByUsuario(Long usuario) {
        return rep.findExtratoByUsuario(usuario).stream().map(CupomMeusDTO::create).collect(Collectors.toList());
    }


    public List<CupomMeusDTO> getExtratoByIdloja(Long idloja) {
        return rep.findExtratoByIdloja(idloja).stream().map(CupomMeusDTO::create).collect(Collectors.toList());
    }



    public List<CupomMeusDTO> getExtratoByCodigo(String codigo) {
        return rep.findExtratoByCodigo(codigo).stream().map(CupomMeusDTO::create).collect(Collectors.toList());
    }


    public CupomMeusDTO insert(CupomMeus pontuacao) {
        Assert.isNull(pontuacao.getId(),"Não foi possível inserir o registro");
        return CupomMeusDTO.create(rep.save(pontuacao));
    }
    public List<CupomMeusDTO> getCupomByUsuario(Long usuario, String tipo) {
        return rep.findCupomByUsuario(usuario,tipo).stream().map(CupomMeusDTO::create).collect(Collectors.toList());
    }

    public CupomMeusDTO update(CupomMeus pontuacao, Long usuario) {
        Assert.notNull(usuario,"Não foi possível atualizar o registro");

        // Busca o carro no banco de dados
        Optional<CupomMeus> optional = rep.findById(usuario);
        if(optional.isPresent()) {
            CupomMeus db = optional.get();
            // Copiar as propriedades
            db.setEcoins(pontuacao.getEcoins());
            db.setPontos(pontuacao.getPontos());
            db.setAtivo(pontuacao.getAtivo());
            db.setModified(pontuacao.getModified());

       //     System.out.println("Pontuacao id " + db.getId());

            // Atualiza a pontuacao
            rep.save(db);

            return CupomMeusDTO.create(db);
        } else {
            return null;
            //throw new RuntimeException("Não foi possível atualizar o registro");
        }
    }

    public void delete(Long id) {
        rep.deleteById(id);
    }



}
