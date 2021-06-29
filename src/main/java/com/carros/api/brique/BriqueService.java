package com.carros.api.brique;

import com.carros.api.infra.exception.ObjectNotFoundException;
import org.modelmapper.internal.util.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BriqueService {

    @Autowired
    private BriqueRepository rep;

    public List<BriqueDTO> getBrique() {
        List<BriqueDTO> list = rep.findAll().stream().map(BriqueDTO::create).collect(Collectors.toList());
        return list;

    }

    public BriqueDTO getRotasById(Long id) {
        Optional<Brique> brique = rep.findById(id);
        return brique.map(BriqueDTO::create).orElseThrow(() -> new ObjectNotFoundException("Rotas não encontrado"));
    }



    public BriqueDTO insert(Brique brique) {
        Assert.isNull(brique.getId(),"Não foi possível inserir o registro");
        return BriqueDTO.create(rep.save(brique));
    }

    public BriqueDTO update(Brique brique, Long id) {
        Assert.notNull(id,"Não foi possível atualizar o registro");

        // Busca o carro no banco de dados
        Optional<Brique> optional = rep.findById(id);
        if(optional.isPresent()) {
            Brique db = optional.get();
            // Copiar as propriedades
            db.setAtivo(brique.getAtivo());
            db.setCidade(brique.getCidade());
            db.setBricado(brique.getBricado());
            db.setCategoria(brique.getCategoria());
            db.setCelular(brique.getCelular());
            db.setCod(brique.getCod());
            db.setContent(brique.getContent());
            db.setDatabrique(brique.getDatabrique());
            db.setDisponibilidade(brique.getDisponibilidade());
            db.setImage(brique.getImage());
            db.setRecompensa(brique.getRecompensa());
            db.setNomecategoria(brique.getNomecategoria());
            db.setTitle(brique.getTitle());
            db.setVisualizado(brique.getVisualizado());
            db.setZap(brique.getZap());
            System.out.println("Rotas id " + db.getId());

            // Atualiza o carro
            rep.save(db);

            return BriqueDTO.create(db);
        } else {
            return null;
            //throw new RuntimeException("Não foi possível atualizar o registro");
        }
    }

    public void delete(Long id) {
        rep.deleteById(id);
    }


    public List<BriqueDTO> getBriqueByCidade(Long cidade) {
        return rep.findByCidade(cidade).stream().map(BriqueDTO::create).collect(Collectors.toList());
    }

    public List<BriqueDTO> getBriqueById(Long usuario) {
        return rep.findByIdk(usuario).stream().map(BriqueDTO::create).collect(Collectors.toList());
    }





    public Long getPerfilBricado(Long usuario) {
        return rep.findPerfilBricado(usuario);
    }
}
