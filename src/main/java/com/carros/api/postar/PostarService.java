package com.carros.api.postar;

import com.carros.api.infra.exception.ObjectNotFoundException;
import org.modelmapper.internal.util.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostarService {

    @Autowired
    private PostarRepository rep;

    public List<PostarDTO> getBrique() {
        List<PostarDTO> list = rep.findAll().stream().map(PostarDTO::create).collect(Collectors.toList());
        return list;

    }

    public PostarDTO getRotasById(Long id) {
        Optional<Postar> brique = rep.findById(id);
        return brique.map(PostarDTO::create).orElseThrow(() -> new ObjectNotFoundException("Rotas não encontrado"));
    }

    public PostarDTO insert(Postar brique) {
        Assert.isNull(brique.getId(),"Não foi possível inserir o registro");
        return PostarDTO.create(rep.save(brique));
    }

    public PostarDTO update(Postar brique, Long id) {
        Assert.notNull(id,"Não foi possível atualizar o registro");

        // Busca o carro no banco de dados
        Optional<Postar> optional = rep.findById(id);
        if(optional.isPresent()) {
            Postar db = optional.get();
            // Copiar as propriedades
            db.setAtivo(brique.getAtivo());
            db.setCidade(brique.getCidade());

            System.out.println("Rotas id " + db.getId());

            // Atualiza o carro
            rep.save(db);

            return PostarDTO.create(db);
        } else {
            return null;
            //throw new RuntimeException("Não foi possível atualizar o registro");
        }
    }

    public void delete(Long id) {
        rep.deleteById(id);
    }


    public List<PostarDTO> getBriqueByCidade(Long cidade) {
        return rep.findByCidade(cidade).stream().map(PostarDTO::create).collect(Collectors.toList());
    }

    public List<PostarDTO> getBriqueById(Long usuario) {
        return rep.findByIdk(usuario).stream().map(PostarDTO::create).collect(Collectors.toList());
    }


    public Long getPerfilBricado(Long usuario) {
        return rep.findPerfilBricado(usuario);
    }

    public List<PostarDTO> getPostarByUsu(Long usuario) {
        return rep.findByUsu(usuario).stream().map(PostarDTO::create).collect(Collectors.toList());

    }
}
