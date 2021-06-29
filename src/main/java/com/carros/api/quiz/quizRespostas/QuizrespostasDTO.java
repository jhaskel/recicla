package com.carros.api.quiz.quizRespostas;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data

public class QuizrespostasDTO {
    private Long id;
    private Long quiz;
    private String resposta;
    private Boolean certa;

    public static QuizrespostasDTO create(Quizrespostas quizcat) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(quizcat, QuizrespostasDTO.class);
    }



}
