package com.carros.api.favoritos;

import com.carros.api.infra.exception.ObjectNotFoundException;
import org.modelmapper.internal.util.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FavoritosService {

    @Autowired
    private FavoritosRepository rep;

    public List<FavoritosDTO> getRotass() {
        List<FavoritosDTO> list = rep.findAll().stream().map(FavoritosDTO::create).collect(Collectors.toList());
        return list;
    }

    public FavoritosDTO getRotasById(Long id) {
        Optional<Favoritos> carro = rep.findById(id);
        return carro.map(FavoritosDTO::create).orElseThrow(() -> new ObjectNotFoundException("Rotas não encontrado"));
    }

    public Long getQuantLidas(Long usuario,String tipo) {
        return rep.findQuantLidas(usuario,tipo);
    }

    public FavoritosDTO insert(Favoritos carro) {
        Assert.isNull(carro.getId(),"Não foi possível inserir o registro");
        return FavoritosDTO.create(rep.save(carro));
    }

    public FavoritosDTO update(Favoritos carro, Long id) {
        Assert.notNull(id,"Não foi possível atualizar o registro");

        // Busca o carro no banco de dados
        Optional<Favoritos> optional = rep.findById(id);
        if(optional.isPresent()) {
            Favoritos db = optional.get();
            // Copiar as propriedades
            db.setAtivo(carro.getAtivo());
            System.out.println("Rotas id " + db.getId());

            // Atualiza o carro
            rep.save(db);

            return FavoritosDTO.create(db);
        } else {
            return null;
            //throw new RuntimeException("Não foi possível atualizar o registro");
        }
    }

    public void delete(Long id) {
        rep.deleteById(id);
    }



    public List<FavoritosDTO> getRotasByCidade(Long usuario,String tipo,Long idevento) {
        return rep.findByCidade(usuario,tipo,idevento).stream().map(FavoritosDTO::create).collect(Collectors.toList());
    }



    public List<FavoritosDTO> getUserTipo(Long usuario,String tipo) {
        return rep.findUserTipo(usuario,tipo).stream().map(FavoritosDTO::create).collect(Collectors.toList());
    }



    public List<FavoritosDTO> getRotasByIcone(Long usuario, String tipo) {
        return rep.findByIcone(usuario,tipo).stream().map(FavoritosDTO::create).collect(Collectors.toList());
    }

    public List<FavoritosDTO> getBriqueByIcone(Long usuario, String tipo) {
        return rep.findByUsuarioIcone(usuario,tipo).stream().map(FavoritosDTO::create).collect(Collectors.toList());
    }

    public List<FavoritosDTO> getFavoritosPostarByIcone(Long usuario, String tipo,Long idevento) {
        return rep.findByFavoritosPostar(usuario,tipo,idevento).stream().map(FavoritosDTO::create).collect(Collectors.toList());
    }

    public double getRe(Long usuario, String tipo, Long idevento) {
        return rep.findSoma(usuario,tipo,idevento);
    }
    public double getQuant(Long usuario, String tipo) {
        return rep.findQuant(usuario,tipo);
    }
}
