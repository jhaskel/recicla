package com.carros.api.desafioCumprido;

import com.carros.api.infra.exception.ObjectNotFoundException;
import io.jsonwebtoken.lang.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DesafioCumpridoService {

    @Autowired
    private DesafioCumpridoRepository rep;

    public List<DesafioCumpridoDTO> getEmpresas() {
        List<DesafioCumpridoDTO> list = rep.findAll().stream().map(DesafioCumpridoDTO::create).collect(Collectors.toList());
        return list;
    }

    public DesafioCumpridoDTO getEmpresaById(Long id) {
        Optional<DesafioCumprido> carro = rep.findById(id);
        return carro.map(DesafioCumpridoDTO::create).orElseThrow(() -> new ObjectNotFoundException("Empresa não encontrado"));
    }
    public List<DesafioCumpridoDTO> getDesafiosByUsuario(Long usuario) {
        return rep.findByUsuario(usuario).stream().map(DesafioCumpridoDTO::create).collect(Collectors.toList());
    }

    public double getRe(Long usuario, Long desafio){
        return rep.findSoma(usuario,desafio);
    }


    public List<DesafioCumpridoDTO> getDesafioCumpridoByUsuarioAndDesafio(Long usuario,Long desafio) {
        return rep.findByDesafio(usuario,desafio).stream().map(DesafioCumpridoDTO::create).collect(Collectors.toList());
    }

    public DesafioCumpridoDTO insert(DesafioCumprido carro) {
        Assert.isNull(carro.getId(),"Não foi possível inserir o registro");
        return DesafioCumpridoDTO.create(rep.save(carro));
    }

    public DesafioCumpridoDTO update(DesafioCumprido carro, Long id) {
        Assert.notNull(id,"Não foi possível atualizar o registro");

        // Busca o carro no banco de dados
        Optional<DesafioCumprido> optional = rep.findById(id);
        if(optional.isPresent()) {
            DesafioCumprido db = optional.get();
            // Copiar as propriedades
            db.setDesafio(carro.getDesafio());
            db.setStatus(carro.getStatus());
            System.out.println("Empresa id " + db.getId());

            // Atualiza o carro
            rep.save(db);

            return DesafioCumpridoDTO.create(db);
        } else {
            return null;
            //throw new RuntimeException("Não foi possível atualizar o registro");
        }
    }

    public void delete(Long id) {
        rep.deleteById(id);
    }


}
