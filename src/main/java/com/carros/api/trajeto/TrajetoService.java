package com.carros.api.trajeto;

import com.carros.api.infra.exception.ObjectNotFoundException;
import io.jsonwebtoken.lang.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TrajetoService {

    @Autowired
    private TrajetoRepository rep;


    public List<TrajetoDTO> getTrajetos() {
        List<TrajetoDTO> list = rep.findAll().stream().map(TrajetoDTO::create).collect(Collectors.toList());
        return list;
    }

    public TrajetoDTO getTrajetoById(Long id) {
        Optional<Trajeto> carro = rep.findById(id);
        return carro.map(TrajetoDTO::create).orElseThrow(() -> new ObjectNotFoundException("Trajeto não encontrado"));
    }

    public TrajetoDTO insert(Trajeto carro) {
        Assert.isNull(carro.getId(),"Não foi possível inserir o registro");
        return TrajetoDTO.create(rep.save(carro));
    }

    public TrajetoDTO update(Trajeto carro, Long id) {
        Assert.notNull(id,"Não foi possível atualizar o registro");

        // Busca o carro no banco de dados
        Optional<Trajeto> optional = rep.findById(id);
        if(optional.isPresent()) {
            Trajeto db = optional.get();
            // Copiar as propriedades
            db.setDia(carro.getDia());
            db.setBairro(carro.getBairro());
            System.out.println("Trajeto id " + db.getId());

            // Atualiza o carro
            rep.save(db);

            return TrajetoDTO.create(db);
        } else {
            return null;
            //throw new RuntimeException("Não foi possível atualizar o registro");
        }
    }

    public void delete(Long id) {
        rep.deleteById(id);
    }


}
