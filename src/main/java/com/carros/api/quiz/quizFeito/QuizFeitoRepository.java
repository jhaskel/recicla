package com.carros.api.quiz.quizFeito;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

interface QuizFeitoRepository extends JpaRepository<QuizFeito, Long> {


    @Query(value = "SELECT * FROM quiz_feito WHERE usuario = :usuario " ,nativeQuery = true)
    List<QuizFeito> findByUsuario(Long usuario);

    @Query(value = "SELECT bri.* from brique bri \n" +
            "INNER JOIN favoritos fav ON fav.idevento = bri.id\n" +
            "WHERE bri.ativo = TRUE and fav.usuario = :usuario AND fav.icone = 4",nativeQuery = true)
    List<QuizFeito> findByIdk(Long usuario);


    @Query(value = "SELECT COUNT(*) AS bricado FROM brique WHERE bricado = :usuario", nativeQuery = true)
    Long findPerfilBricado(Long usuario);


    @Query(value = "SELECT COUNT(id) FROM quiz_feito WHERE usuario = :usuario and hoje =:hoje", nativeQuery = true)
    Long findQuizDia(Long usuario,String hoje);


    @Query(value = "SELECT COUNT(id) FROM quiz_feito WHERE usuario = :usuario ", nativeQuery = true)
    Long findQuantQuiz(Long usuario);
}
