package com.carros.api.rotas.rotadias;

import com.carros.api.infra.exception.ObjectNotFoundException;
import org.modelmapper.internal.util.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RotadiasService {

    @Autowired
    private RotadiasRepository rep;

    public List<RotadiasDTO> getRotass() {
        List<RotadiasDTO> list = rep.findAll().stream().map(RotadiasDTO::create).collect(Collectors.toList());
        return list;
    }

    public RotadiasDTO getRotasById(Long id) {
        Optional<Rotadias> carro = rep.findById(id);
        return carro.map(RotadiasDTO::create).orElseThrow(() -> new ObjectNotFoundException("Rotas não encontrado"));
    }

    public RotadiasDTO insert(Rotadias carro) {
        Assert.isNull(carro.getId(),"Não foi possível inserir o registro");
        return RotadiasDTO.create(rep.save(carro));
    }

    public RotadiasDTO update(Rotadias carro, Long id) {
        Assert.notNull(id,"Não foi possível atualizar o registro");

        // Busca o carro no banco de dados
        Optional<Rotadias> optional = rep.findById(id);
        if(optional.isPresent()) {
            Rotadias db = optional.get();
            // Copiar as propriedades
            db.setAtivo(carro.getAtivo());
            db.setAtivo(carro.getAtivo());
            System.out.println("Rotas id " + db.getId());

            // Atualiza o carro
            rep.save(db);

            return RotadiasDTO.create(db);
        } else {
            return null;
            //throw new RuntimeException("Não foi possível atualizar o registro");
        }
    }

    public void delete(Long id) {
        rep.deleteById(id);
    }


    public List<RotadiasDTO> getRotasByRota(Long rota) {
        return rep.findByRota(rota).stream().map(RotadiasDTO::create).collect(Collectors.toList());
    }

    public List<RotadiasDTO> getRotasByBairro(Long bairro) {
        return rep.findByBairro(bairro).stream().map(RotadiasDTO::create).collect(Collectors.toList());
    }
}
