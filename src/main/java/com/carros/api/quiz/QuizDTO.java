package com.carros.api.quiz;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data

public class QuizDTO {
    private Long id;
    private Long categoria;
    private String pergunta;





    public static QuizDTO create(Quiz brique) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(brique, QuizDTO.class);
    }



}
