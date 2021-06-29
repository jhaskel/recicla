package com.carros.api.quiz.quizcat;

import lombok.Data;
import org.modelmapper.ModelMapper;

import javax.servlet.Registration;
import javax.swing.*;

@Data

public class QuizcatDTO {
    private Long id;
    private String nome;
    private String icone;

    public static QuizcatDTO create(Quizcat quizcat) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(quizcat, QuizcatDTO.class);
    }



}
