package com.carros.api.quiz.quizRespostas;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Arrays;
import java.util.List;

interface QuizrespostasRepository extends JpaRepository<Quizrespostas, Long> {


    @Query(value = "SELECT * FROM quizrespostas WHERE quiz = :quiz order by rand()",nativeQuery = true)
    List<Quizrespostas> findByQuiz(Long quiz);

}
