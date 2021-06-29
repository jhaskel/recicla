package com.carros.api.quiz;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

interface QuizRepository extends JpaRepository<Quiz, Long> {


    @Query(value = "SELECT * FROM quiz WHERE categoria = :categoria order by rand() limit 4" ,nativeQuery = true)
    List<Quiz> findByCategoria(Long categoria);

    @Query(value = "SELECT bri.* from brique bri \n" +
            "INNER JOIN favoritos fav ON fav.idevento = bri.id\n" +
            "WHERE bri.ativo = TRUE and fav.usuario = :usuario AND fav.icone = 4",nativeQuery = true)
    List<Quiz> findByIdk(Long usuario);


    @Query(value = "SELECT COUNT(*) AS bricado FROM brique WHERE bricado = :usuario", nativeQuery = true)
    Long findPerfilBricado(Long usuario);
}
