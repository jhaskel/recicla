package com.carros.api.cidades;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository rep;

    public List<CidadeDTO> getCidade() {
        return rep.findAll().stream().map(CidadeDTO::create).collect(Collectors.toList());
    }

    public List<CidadeDTO> getCidadeByCidade(Long cidade) {
        return rep.findByCidade(cidade).stream().map(CidadeDTO::create).collect(Collectors.toList());
    }

    public CidadeDTO insert(Cidade cidade) {
        Assert.isNull(cidade.getId(),"Não foi possível inserir o registro");
        return CidadeDTO.create(rep.save(cidade));
    }

    public CidadeDTO update(Cidade cidade, Long usuario) {
        Assert.notNull(usuario,"Não foi possível atualizar o registro");

        // Busca o carro no banco de dados
        Optional<Cidade> optional = rep.findById(usuario);
        if(optional.isPresent()) {
            Cidade db = optional.get();
            // Copiar as propriedades
            db.setNome(cidade.getNome());
            db.setIcone(cidade.getIcone());

            //     System.out.println("Cidade id " + db.getId());

            // Atualiza a pontuacao
            rep.save(db);

            return CidadeDTO.create(db);
        } else {
            return null;
            //throw new RuntimeException("Não foi possível atualizar o registro");
        }
    }
    public void delete(Long id) {
        rep.deleteById(id);
    }

}