package com.carros.api.peso;

import com.carros.api.infra.exception.ObjectNotFoundException;
import io.jsonwebtoken.lang.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PesoService {

    @Autowired
    private PesoRepository rep;


    public List<PesoDTO> getTrajetos() {
        List<PesoDTO> list = rep.findAll().stream().map(PesoDTO::create).collect(Collectors.toList());
        return list;
    }

    public PesoDTO getTrajetoById(Long id) {
        Optional<Peso> carro = rep.findById(id);
        return carro.map(PesoDTO::create).orElseThrow(() -> new ObjectNotFoundException("Trajeto não encontrado"));
    }

    public PesoDTO insert(Peso carro) {
        Assert.isNull(carro.getId(),"Não foi possível inserir o registro");
        return PesoDTO.create(rep.save(carro));
    }

    public PesoDTO update(Peso carro, Long id) {
        Assert.notNull(id,"Não foi possível atualizar o registro");

        // Busca o carro no banco de dados
        Optional<Peso> optional = rep.findById(id);
        if(optional.isPresent()) {
            Peso db = optional.get();
            // Copiar as propriedades
          //  db.setDia(carro.getDia());
         //   db.setBairro(carro.getBairro());
            System.out.println("Trajeto id " + db.getId());

            // Atualiza o carro
            rep.save(db);

            return PesoDTO.create(db);
        } else {
            return null;
            //throw new RuntimeException("Não foi possível atualizar o registro");
        }
    }

    public void delete(Long id) {
        rep.deleteById(id);
    }


}
