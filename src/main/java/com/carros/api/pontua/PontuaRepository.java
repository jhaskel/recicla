package com.carros.api.pontua;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Arrays;
import java.util.List;

public interface PontuaRepository extends JpaRepository<Pontua, Long> {




    @Query(value = "select * from pontuacao  where usuario = :usuario ORDER BY hoje desc", nativeQuery = true)
    List<Pontua> findExtratoByUsuario(Long usuario);



    @Query(value = "select count(id)  from pontuacao where ano = :ano and mes = :mes and usuario = :usuario and icone = 4", nativeQuery = true)
    Long findPontosMes(Long usuario, Long ano, Long mes);
}
