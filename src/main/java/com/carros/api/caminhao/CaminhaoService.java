package com.carros.api.caminhao;

import com.carros.api.infra.exception.ObjectNotFoundException;
import org.springframework.util.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CaminhaoService {

    @Autowired
    private CaminhaoRepository rep;

    public List<CaminhaoDTO> getCaminhaos() {
        List<CaminhaoDTO> list = rep.findAll().stream().map(CaminhaoDTO::create).collect(Collectors.toList());
        return list;
    }

    public CaminhaoDTO getCaminhaoById(Long id) {
        Optional<Caminhao> carro = rep.findById(id);
        return carro.map(CaminhaoDTO::create).orElseThrow(() -> new ObjectNotFoundException("Caminhao não encontrado"));
    }

    public CaminhaoDTO insert(Caminhao carro) {
        Assert.isNull(carro.getId(),"Não foi possível inserir o registro");
        return CaminhaoDTO.create(rep.save(carro));
    }

    public CaminhaoDTO update(Caminhao carro, Long id) {
        Assert.notNull(id,"Não foi possível atualizar o registro");

        // Busca o carro no banco de dados
        Optional<Caminhao> optional = rep.findById(id);
        if(optional.isPresent()) {
            Caminhao db = optional.get();
            // Copiar as propriedades

            db.setColetando(carro.getColetando());
            db.setLatitude(carro.getLatitude());
            db.setLongitude(carro.getLongitude());


            System.out.println("Caminhao id " + db.getId());

            // Atualiza o carro
            rep.save(db);

            return CaminhaoDTO.create(db);
        } else {
            return null;
            //throw new RuntimeException("Não foi possível atualizar o registro");
        }
    }

    public void delete(Long id) {
        rep.deleteById(id);
    }


    public List<CaminhaoDTO> getCaminhaoByIdEmpresa(Long idempresa) {
        return rep.findByIdEmpresa(idempresa).stream().map(CaminhaoDTO::create).collect(Collectors.toList());
    }
}
