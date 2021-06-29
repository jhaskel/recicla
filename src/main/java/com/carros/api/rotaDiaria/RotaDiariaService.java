package com.carros.api.rotaDiaria;

import com.carros.api.infra.exception.ObjectNotFoundException;
import io.jsonwebtoken.lang.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RotaDiariaService {

    @Autowired
    private RotaDiariaRepository rep;


    public List<RotaDiariaDTO> getRotaDiarias() {
        List<RotaDiariaDTO> list = rep.findAll().stream().map(RotaDiariaDTO::create).collect(Collectors.toList());
        return list;
    }

    public RotaDiariaDTO getRotaDiariaById(Long id) {
        Optional<RotaDiaria> carro = rep.findById(id);
        return carro.map(RotaDiariaDTO::create).orElseThrow(() -> new ObjectNotFoundException("RotaDiaria não encontrado"));
    }

    public RotaDiariaDTO insert(RotaDiaria carro) {
        Assert.isNull(carro.getId(),"Não foi possível inserir o registro");
        return RotaDiariaDTO.create(rep.save(carro));
    }

    public RotaDiariaDTO update(RotaDiaria carro, Long id) {
        Assert.notNull(id,"Não foi possível atualizar o registro");

        // Busca o carro no banco de dados
        Optional<RotaDiaria> optional = rep.findById(id);
        if(optional.isPresent()) {
            RotaDiaria db = optional.get();
            // Copiar as propriedades
            db.setDia(carro.getDia());
            db.setDia(carro.getDia());
            System.out.println("RotaDiaria id " + db.getId());

            // Atualiza o carro
            rep.save(db);

            return RotaDiariaDTO.create(db);
        } else {
            return null;
            //throw new RuntimeException("Não foi possível atualizar o registro");
        }
    }

    public void delete(Long id) {
        rep.deleteById(id);
    }


    public List<RotaDiariaDTO> getRotaByDia(Long dia) {
        return rep.findRotaByDia(dia).stream().map(RotaDiariaDTO::create).collect(Collectors.toList());
    }

    public List<RotaDiariaDTO> getRotaBySemana(Long semana, Long ano) {
        return rep.findRotaBySemana(semana,ano).stream().map(RotaDiariaDTO::create).collect(Collectors.toList());
    }

    public List<RotaDiariaDTO> getRotaByIdrota(Long idrota) {
        return rep.findRotaByIdrota(idrota).stream().map(RotaDiariaDTO::create).collect(Collectors.toList());
    }

    public List<RotaDiariaDTO> getRotaByMes(Long mes, Long ano) {
        return rep.findRotaByMes(mes,ano).stream().map(RotaDiariaDTO::create).collect(Collectors.toList());
    }

    public List<RotaDiariaDTO> getRotaByAno(Long ano) {
        return rep.findRotaByAno(ano).stream().map(RotaDiariaDTO::create).collect(Collectors.toList());
    }

    public List<RotaDiariaDTO> getRotaByIdempresa(Long idempresa) {
        return rep.findRotaByIdempresa(idempresa).stream().map(RotaDiariaDTO::create).collect(Collectors.toList());
    }

    public List<RotaDiariaDTO> getRotaByIdcaminhao(Long idcaminhao) {
        return rep.findRotaByIdcaminhao(idcaminhao).stream().map(RotaDiariaDTO::create).collect(Collectors.toList());
    }

    public List<RotaDiariaDTO> getRotaByUsuario(Long usuario) {
        return rep.findRotaByUsuario(usuario).stream().map(RotaDiariaDTO::create).collect(Collectors.toList());
    }

    public List<RotaDiariaDTO> getRotaByIdcoleta(Long idcoleta) {
        return rep.findRotaByIdcoleta(idcoleta).stream().map(RotaDiariaDTO::create).collect(Collectors.toList());
    }
}
