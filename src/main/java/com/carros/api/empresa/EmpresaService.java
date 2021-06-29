package com.carros.api.empresa;

import com.carros.api.infra.exception.ObjectNotFoundException;
import io.jsonwebtoken.lang.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository rep;

    public List<EmpresaDTO> getEmpresas() {
        List<EmpresaDTO> list = rep.findAll().stream().map(EmpresaDTO::create).collect(Collectors.toList());
        return list;
    }

    public EmpresaDTO getEmpresaById(Long id) {
        Optional<Empresa> carro = rep.findById(id);
        return carro.map(EmpresaDTO::create).orElseThrow(() -> new ObjectNotFoundException("Empresa não encontrado"));
    }

    public EmpresaDTO insert(Empresa carro) {
        Assert.isNull(carro.getId(),"Não foi possível inserir o registro");
        return EmpresaDTO.create(rep.save(carro));
    }

    public EmpresaDTO update(Empresa carro, Long id) {
        Assert.notNull(id,"Não foi possível atualizar o registro");

        // Busca o carro no banco de dados
        Optional<Empresa> optional = rep.findById(id);
        if(optional.isPresent()) {
            Empresa db = optional.get();
            // Copiar as propriedades
            db.setBairro(carro.getBairro());
            db.setCelular(carro.getCelular());
            System.out.println("Empresa id " + db.getId());

            // Atualiza o carro
            rep.save(db);

            return EmpresaDTO.create(db);
        } else {
            return null;
            //throw new RuntimeException("Não foi possível atualizar o registro");
        }
    }

    public void delete(Long id) {
        rep.deleteById(id);
    }


}
