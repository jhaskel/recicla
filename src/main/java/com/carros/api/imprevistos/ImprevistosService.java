package com.carros.api.imprevistos;

import com.carros.api.infra.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ImprevistosService {

    @Autowired
    private ImprevistosRepository rep;

    public List<ImprevistosDTO> getImprevistos() {
        List<ImprevistosDTO> list = rep.findAll().stream().map(ImprevistosDTO::create).collect(Collectors.toList());
        return list;
    }

    public ImprevistosDTO getImprevistoById(Long id) {
        Optional<Imprevistos> carro = rep.findById(id);
        return carro.map(ImprevistosDTO::create).orElseThrow(() -> new ObjectNotFoundException("Imprevisto não encontrado"));
    }

    public ImprevistosDTO insert(Imprevistos carro) {
        Assert.isNull(carro.getId(),"Não foi possível inserir o registro");
        return ImprevistosDTO.create(rep.save(carro));
    }

    public ImprevistosDTO update(Imprevistos carro, Long id) {
        Assert.notNull(id,"Não foi possível atualizar o registro");

        // Busca o carro no banco de dados
        Optional<Imprevistos> optional = rep.findById(id);
        if(optional.isPresent()) {
            Imprevistos db = optional.get();
            // Copiar as propriedades
            db.setContent(carro.getContent());
            db.setHora(carro.getHora());
            System.out.println("Imprevisto id " + db.getId());

            // Atualiza o carro
            rep.save(db);

            return ImprevistosDTO.create(db);
        } else {
            return null;
            //throw new RuntimeException("Não foi possível atualizar o registro");
        }
    }

    public void delete(Long id) {
        rep.deleteById(id);
    }


    public List<ImprevistosDTO> getImprevistoByColeta(String dia,Long coleta) {
        return rep.findByAlgo(dia,coleta).stream().map(ImprevistosDTO::create).collect(Collectors.toList());

    }
}
