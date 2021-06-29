package com.carros.api.desafios;

import com.carros.api.infra.exception.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DesafioService {

    @Autowired
    private DesafioRepository rep;
    public List<DesafioDTO> getDesafios() {
        List<DesafioDTO> list = rep.findAll().stream().map(DesafioDTO::create).collect(Collectors.toList());
        return list;
    }

    public DesafioDTO getCarroById(Long id) {
        Optional<Desafio> desafio = rep.findById(id);
        return desafio.map(DesafioDTO::create).orElseThrow(() -> new ObjectNotFoundException("Desafio não encontrado"));
    }

    public List<DesafioDTO> getDesafiosByTipo(String tipo) {
        return rep.findByTipo(tipo).stream().map(DesafioDTO::create).collect(Collectors.toList());
    }

    public DesafioDTO insert(Desafio desafio) {
        Assert.isNull(desafio.getId(),"Não foi possível inserir o registro");
        return DesafioDTO.create(rep.save(desafio));
    }
    public List<DesafioDTO> getColetandoByDesafios(Long cidade,Long usuario) {
        return rep.findByAlgo(cidade,usuario).stream().map(DesafioDTO::create).collect(Collectors.toList());
    }

    public DesafioDTO update(Desafio desafio, Long id) {
        Assert.notNull(id,"Não foi possível atualizar o registro");

        // Busca o desafio no banco de dados
        Optional<Desafio> optional = rep.findById(id);
        if(optional.isPresent()) {
            Desafio db = optional.get();
            // Copiar as propriedades
            db.setCidade(desafio.getCidade());
            db.setNome(desafio.getNome());
            db.setTipo(desafio.getTipo());
            db.setTipo(desafio.getTipo());
            db.setDescricao(desafio.getDescricao());
            db.setUrlFoto(desafio.getUrlFoto());
            db.setUrlVideo(desafio.getUrlVideo());
            db.setQuantidade(desafio.getQuantidade());
            db.setPontuacao(desafio.getPontuacao());
            db.setAtivo(desafio.getAtivo());

            System.out.println("Desafio id " + db.getId());

            // Atualiza o desafio
            rep.save(db);

            return DesafioDTO.create(db);
        } else {
            return null;
            //throw new RuntimeException("Não foi possível atualizar o registro");
        }
    }

    public void delete(Long id) {
        rep.deleteById(id);
    }


}
