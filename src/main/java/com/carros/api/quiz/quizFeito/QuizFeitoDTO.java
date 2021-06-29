package com.carros.api.quiz.quizFeito;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data

public class QuizFeitoDTO {
    private Long id;
    private Long usuario;
    private Long cidade;
    private Long categoria;
    private Long pontos;
    private String quiz;
    private String created;
    private String hoje;





    public static QuizFeitoDTO create(QuizFeito brique) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(brique, QuizFeitoDTO.class);
    }



}
