package com.carros.api.quiz.quizFeito;

import com.carros.api.infra.exception.ObjectNotFoundException;
import org.modelmapper.internal.util.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuizFeitoService {

    @Autowired
    private QuizFeitoRepository rep;

    public List<QuizFeitoDTO> getBrique() {
        List<QuizFeitoDTO> list = rep.findAll().stream().map(QuizFeitoDTO::create).collect(Collectors.toList());
        return list;

    }

    public QuizFeitoDTO getRotasById(Long id) {
        Optional<QuizFeito> brique = rep.findById(id);
        return brique.map(QuizFeitoDTO::create).orElseThrow(() -> new ObjectNotFoundException("Rotas não encontrado"));
    }

    public QuizFeitoDTO insert(QuizFeito brique) {
        Assert.isNull(brique.getId(),"Não foi possível inserir o registro");
        return QuizFeitoDTO.create(rep.save(brique));
    }

    public QuizFeitoDTO update(QuizFeito brique, Long id) {
        Assert.notNull(id,"Não foi possível atualizar o registro");

        // Busca o carro no banco de dados
        Optional<QuizFeito> optional = rep.findById(id);
        if(optional.isPresent()) {
            QuizFeito db = optional.get();
            // Copiar as propriedades
            db.setCategoria(brique.getCategoria());

            System.out.println("Rotas id " + db.getId());

            // Atualiza o carro
            rep.save(db);

            return QuizFeitoDTO.create(db);
        } else {
            return null;
            //throw new RuntimeException("Não foi possível atualizar o registro");
        }
    }

    public void delete(Long id) {
        rep.deleteById(id);
    }


    public List<QuizFeitoDTO> getQuizByUsuario(Long usuario) {
        return rep.findByUsuario(usuario).stream().map(QuizFeitoDTO::create).collect(Collectors.toList());
    }

    public List<QuizFeitoDTO> getBriqueById(Long usuario) {
        return rep.findByIdk(usuario).stream().map(QuizFeitoDTO::create).collect(Collectors.toList());
    }


    public Long getPerfilBricado(Long usuario) {
        return rep.findPerfilBricado(usuario);
    }

    public Long getQuizDia(Long usuario,String hoje) {
        return rep.findQuizDia(usuario,hoje);
    }

    public Long getQuantQuizByUsuario(Long usuario) {
        return rep.findQuantQuiz(usuario);
    }


}
