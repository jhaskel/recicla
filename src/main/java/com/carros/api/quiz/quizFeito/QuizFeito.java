package com.carros.api.quiz.quizFeito;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class QuizFeito {
    @Id //define chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long usuario;
    private Long cidade;
    private Long categoria;
    private Long pontos;
    private String quiz;
    private String created;
    private String hoje;










}
