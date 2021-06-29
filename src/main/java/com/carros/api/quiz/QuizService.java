package com.carros.api.quiz;

import com.carros.api.infra.exception.ObjectNotFoundException;
import org.modelmapper.internal.util.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuizService {

    @Autowired
    private QuizRepository rep;

    public List<QuizDTO> getBrique() {
        List<QuizDTO> list = rep.findAll().stream().map(QuizDTO::create).collect(Collectors.toList());
        return list;

    }

    public QuizDTO getRotasById(Long id) {
        Optional<Quiz> brique = rep.findById(id);
        return brique.map(QuizDTO::create).orElseThrow(() -> new ObjectNotFoundException("Rotas não encontrado"));
    }

    public QuizDTO insert(Quiz brique) {
        Assert.isNull(brique.getId(),"Não foi possível inserir o registro");
        return QuizDTO.create(rep.save(brique));
    }

    public QuizDTO update(Quiz brique, Long id) {
        Assert.notNull(id,"Não foi possível atualizar o registro");

        // Busca o carro no banco de dados
        Optional<Quiz> optional = rep.findById(id);
        if(optional.isPresent()) {
            Quiz db = optional.get();
            // Copiar as propriedades
            db.setCategoria(brique.getCategoria());

            System.out.println("Rotas id " + db.getId());

            // Atualiza o carro
            rep.save(db);

            return QuizDTO.create(db);
        } else {
            return null;
            //throw new RuntimeException("Não foi possível atualizar o registro");
        }
    }

    public void delete(Long id) {
        rep.deleteById(id);
    }


    public List<QuizDTO> getBriqueByCategoria(Long categoria) {
        return rep.findByCategoria(categoria).stream().map(QuizDTO::create).collect(Collectors.toList());
    }

    public List<QuizDTO> getBriqueById(Long usuario) {
        return rep.findByIdk(usuario).stream().map(QuizDTO::create).collect(Collectors.toList());
    }


    public Long getPerfilBricado(Long usuario) {
        return rep.findPerfilBricado(usuario);
    }
}
