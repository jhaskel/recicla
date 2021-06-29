package com.carros.api.rotasUser;

import com.carros.api.infra.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RotasUserService {

    @Autowired
    private RotasUserRepository rep;

    public List<RotasUserDTO> getRotasUsers() {
        List<RotasUserDTO> list = rep.findAll().stream().map(RotasUserDTO::create).collect(Collectors.toList());
        return list;
    }

    public RotasUserDTO getRotasUserById(Long id) {
        Optional<RotasUser> carro = rep.findById(id);
        return carro.map(RotasUserDTO::create).orElseThrow(() -> new ObjectNotFoundException("RotasUser não encontrado"));
    }

    public RotasUserDTO insert(RotasUser carro) {
        Assert.isNull(carro.getId(),"Não foi possível inserir o registro");
        return RotasUserDTO.create(rep.save(carro));
    }

    public RotasUserDTO update(RotasUser carro, Long id) {
        Assert.notNull(id,"Não foi possível atualizar o registro");

        // Busca o carro no banco de dados
        Optional<RotasUser> optional = rep.findById(id);
        if(optional.isPresent()) {
            RotasUser db = optional.get();
            // Copiar as propriedades
            db.setRota(carro.getRota());
            db.setUser(carro.getUser());
            System.out.println("RotasUser id " + db.getId());

            // Atualiza o carro
            rep.save(db);

            return RotasUserDTO.create(db);
        } else {
            return null;
            //throw new RuntimeException("Não foi possível atualizar o registro");
        }
    }

    public void delete(Long id) {
        rep.deleteById(id);
    }


    public List<RotasUserDTO> getERotaByUser(Long user) {
        return rep.findRotaByUser(user).stream().map(RotasUserDTO::create).collect(Collectors.toList());
    }
}
