package com.carros.api.coletando;

import com.carros.api.infra.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ColetandoService {

    @Autowired
    private ColetandoRepository rep;

    public List<ColetandoDTO> getColetandos() {
        List<ColetandoDTO> list = rep.findAll().stream().map(ColetandoDTO::create).collect(Collectors.toList());
        return list;
    }

    public ColetandoDTO getColetandoById(Long id) {
        Optional<Coletando> carro = rep.findById(id);
        return carro.map(ColetandoDTO::create).orElseThrow(() -> new ObjectNotFoundException("Coletando não encontrado"));
    }

    public double VerificaRotaDia(Long cidade,Long bairro,String dia){
        return rep.findSomaRotaDia(cidade,bairro,dia);
    }

    public ColetandoDTO insert(Coletando carro) {
        Assert.isNull(carro.getId(),"Não foi possível inserir o registro");
        return ColetandoDTO.create(rep.save(carro));
    }

    public ColetandoDTO update(Coletando carro, Long id) {
        Assert.notNull(id,"Não foi possível atualizar o registro");

        // Busca o carro no banco de dados
        Optional<Coletando> optional = rep.findById(id);
        if(optional.isPresent()) {
            Coletando db = optional.get();
            // Copiar as propriedades
            db.setAtivo(carro.getAtivo());
            db.setLatitude(carro.getLatitude());
            db.setLongitude(carro.getLongitude());
            db.setHora(carro.getHora());
            db.setStatus(carro.getStatus());
            db.setPeso(carro.getPeso());
            System.out.println("Coletando id " + db.getId());

            // Atualiza o carro
            rep.save(db);

            return ColetandoDTO.create(db);
        } else {
            return null;
            //throw new RuntimeException("Não foi possível atualizar o registro");
        }
    }

    public void delete(Long id) {
        rep.deleteById(id);
    }


    public List<ColetandoDTO> getColetandoByColeta(Long id) {
        return rep.findByAlgo(id).stream().map(ColetandoDTO::create).collect(Collectors.toList());

    }

    public List<ColetandoDTO> getColetandoByUsuario(Long usuario) {
        return rep.findByUsuario(usuario).stream().map(ColetandoDTO::create).collect(Collectors.toList());
    }
}
