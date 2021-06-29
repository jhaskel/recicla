package com.carros.api.coletando.coletacrud;

import com.carros.api.infra.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ColetacrudService {

    @Autowired
    private ColetacrudRepository rep;

    public List<ColetacrudDTO> getColetandos() {
        List<ColetacrudDTO> list = rep.findAll().stream().map(ColetacrudDTO::create).collect(Collectors.toList());
        return list;
    }

    public ColetacrudDTO getColetandoById(Long id) {
        Optional<Coletacrud> carro = rep.findById(id);
        return carro.map(ColetacrudDTO::create).orElseThrow(() -> new ObjectNotFoundException("Coletando não encontrado"));
    }

    public ColetacrudDTO insert(Coletacrud carro) {
        Assert.isNull(carro.getId(),"Não foi possível inserir o registro");
        return ColetacrudDTO.create(rep.save(carro));
    }

    public ColetacrudDTO update(Coletacrud carro, Long id) {
        Assert.notNull(id,"Não foi possível atualizar o registro");

        // Busca o carro no banco de dados
        Optional<Coletacrud> optional = rep.findById(id);
        if(optional.isPresent()) {
            Coletacrud db = optional.get();
            // Copiar as propriedades
            db.setAtivo(carro.getAtivo());
            db.setCidade(carro.getCidade());
            System.out.println("Coletando id " + db.getId());

            // Atualiza o carro
            rep.save(db);

            return ColetacrudDTO.create(db);
        } else {
            return null;
            //throw new RuntimeException("Não foi possível atualizar o registro");
        }
    }

    public void delete(Long id) {
        rep.deleteById(id);
    }


    public List<ColetacrudDTO> getColetacrudByCidade(Long cidade,String dia) {
        return rep.findByCidade(cidade,dia).stream().map(ColetacrudDTO::create).collect(Collectors.toList());
    }
}
