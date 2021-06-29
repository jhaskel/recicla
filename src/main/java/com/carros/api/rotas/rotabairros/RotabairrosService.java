package com.carros.api.rotas.rotabairros;

import com.carros.api.infra.exception.ObjectNotFoundException;
import org.modelmapper.internal.util.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RotabairrosService {

    @Autowired
    private RotabairrosRepository rep;

    public List<RotabairrosDTO> getRotass() {
        List<RotabairrosDTO> list = rep.findAll().stream().map(RotabairrosDTO::create).collect(Collectors.toList());
        return list;
    }

    public RotabairrosDTO getRotasById(Long id) {
        Optional<Rotabairros> carro = rep.findById(id);
        return carro.map(RotabairrosDTO::create).orElseThrow(() -> new ObjectNotFoundException("Rotas não encontrado"));
    }

    public RotabairrosDTO insert(Rotabairros carro) {
        Assert.isNull(carro.getId(),"Não foi possível inserir o registro");
        return RotabairrosDTO.create(rep.save(carro));
    }

    public RotabairrosDTO update(Rotabairros carro, Long id) {
        Assert.notNull(id,"Não foi possível atualizar o registro");

        // Busca o carro no banco de dados
        Optional<Rotabairros> optional = rep.findById(id);
        if(optional.isPresent()) {
            Rotabairros db = optional.get();
            // Copiar as propriedades
            db.setAtivo(carro.getAtivo());
            db.setAtivo(carro.getAtivo());
            System.out.println("Rotas id " + db.getId());

            // Atualiza o carro
            rep.save(db);

            return RotabairrosDTO.create(db);
        } else {
            return null;
            //throw new RuntimeException("Não foi possível atualizar o registro");
        }
    }

    public void delete(Long id) {
        rep.deleteById(id);
    }


    public List<RotabairrosDTO> getRotasByRota(Long rota) {
        return rep.findByRota(rota).stream().map(RotabairrosDTO::create).collect(Collectors.toList());
    }

    public List<RotabairrosDTO> getRotasByBairro(Long bairro) {
        return rep.findByBairro(bairro).stream().map(RotabairrosDTO::create).collect(Collectors.toList());
    }
}
