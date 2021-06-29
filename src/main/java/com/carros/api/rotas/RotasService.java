package com.carros.api.rotas;

import com.carros.api.infra.exception.ObjectNotFoundException;
import org.modelmapper.internal.util.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RotasService {

    @Autowired
    private RotasRepository rep;

    public List<RotasDTO> getRotass() {
        List<RotasDTO> list = rep.findAll().stream().map(RotasDTO::create).collect(Collectors.toList());
        return list;
    }

    public RotasDTO getRotasById(Long id) {
        Optional<Rotas> carro = rep.findById(id);
        return carro.map(RotasDTO::create).orElseThrow(() -> new ObjectNotFoundException("Rotas não encontrado"));
    }

    public RotasDTO insert(Rotas carro) {
        Assert.isNull(carro.getId(),"Não foi possível inserir o registro");
        return RotasDTO.create(rep.save(carro));
    }

    public RotasDTO update(Rotas carro, Long id) {
        Assert.notNull(id,"Não foi possível atualizar o registro");

        // Busca o carro no banco de dados
        Optional<Rotas> optional = rep.findById(id);
        if(optional.isPresent()) {
            Rotas db = optional.get();
            // Copiar as propriedades
            db.setAtivo(carro.getAtivo());
            db.setCidade(carro.getCidade());
            System.out.println("Rotas id " + db.getId());

            // Atualiza o carro
            rep.save(db);

            return RotasDTO.create(db);
        } else {
            return null;
            //throw new RuntimeException("Não foi possível atualizar o registro");
        }
    }

    public void delete(Long id) {
        rep.deleteById(id);
    }


    public List<RotasDTO> getRotasByCidade(Long cidade) {
        return rep.findByCidade(cidade).stream().map(RotasDTO::create).collect(Collectors.toList());
    }
}
