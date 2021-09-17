package com.carros.api.pontuacao;

import com.carros.api.pontua.Pontua;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import java.util.Optional;

public interface PontuacaoRepository extends JpaRepository<Pontuacao, Long> {

 //calcula o total de pontos por ano de um determinado usuario
 @Query(value = "select sum(ecoins) as ecoins from pontuacao where ano = :ano and usuario = :usuario", nativeQuery = true)
 double findSoma(Long usuario, Long ano);

 //calcula o total por mes de um determinado usuario
 @Query(value = "select sum(ecoins) as ecoins from pontuacao where ano = :ano and mes = :mes and usuario = :usuario", nativeQuery = true)
 double findSomaMes(Long usuario, Long ano, Long mes);

 //retorna ranking de ecoins por ano
 @Query(value = "select  *,sum(pon.ecoins) as total from pontuacao pon\n" +
           "inner join user on user.id = pon.usuario\n" +
           " where pon.ano = :ano group by pon.usuario order by total desc", nativeQuery = true)
    List<Pontuacao> findByAno(Long ano);

 //retorna a lista rankiada de ecoins  por mes
    @Query(value = "select  *,sum(pon.ecoins) as total ,user.nome from pontuacao pon\n" +
            "inner join user on user.id = pon.usuario\n" +
            " where pon.ano = :ano and pon.mes = :mes group by pon.usuario order by total desc", nativeQuery = true)
    List<Pontuacao> findByMes(Long ano,Long mes);

 //retorna a lista rankiada de ecoins  por semana
 @Query(value = "select  *,sum(pon.ecoins) as total ,user.nome from pontuacao pon\n" +
         "inner join user on user.id = pon.usuario\n" +
         " where pon.ano = :ano and pon.semana = :semana group by pon.usuario order by total desc", nativeQuery = true)
 List<Pontuacao> findEcoinsBySemana(Long ano, Long semana);

    @Query(value = "select * from pontuacao  where usuario = :usuario ORDER BY hoje ", nativeQuery = true)
    List<Pontua> findExtratoByUsuario(Long usuario);



 //calcula o total de pontos  de um determinado usuario
 @Query(value = "select sum(pontos) as pontos from pontuacao where  usuario = :usuario", nativeQuery = true)
    double findPontoTotal(Long usuario);

 //calcula o total de pontos por ano de um determinado usuario
 @Query(value = "select sum(pontos) as pontos from pontuacao where ano = :ano and usuario = :usuario", nativeQuery = true)
 double findPontoSoma(Long usuario, Long ano);

 //calcula o total de pontos por mes de um determinado usuario
    @Query(value = "select sum(pontos) as pontos from pontuacao where ano = :ano and mes = :mes and usuario = :usuario", nativeQuery = true)
    double findPontosMes(Long usuario, Long ano, Long mes);

 //retorna ranking de pontos por ano
    @Query(value = "select  *,sum(pon.pontos) as total from pontuacao pon\n" +
            "inner join user on user.id = pon.usuario\n" +
            " where pon.ano = :ano and pon.cidade = :cidade group by pon.usuario order by total desc", nativeQuery = true)
    List<Pontuacao> findPontosByAno(Long ano,Long cidade);

 //retorna ranking de pontos
    @Query(value = "select  *,sum(pon.pontos) as total from pontuacao pon\n" +
            "inner join user on user.id = pon.usuario\n" +
            " group by pon.usuario order by total desc", nativeQuery = true)
    List<Pontuacao>  findPontos();

 //retorna a lista rankiada de pontos  por mes
    @Query(value = "select  *,sum(pon.pontos) as total ,user.nome from pontuacao pon\n" +
            "inner join user on user.id = pon.usuario\n" +
            " where pon.ano = :ano and pon.mes = :mes and pon.cidade = :cidade group by pon.usuario order by total desc", nativeQuery = true)
    List<Pontuacao> findPontosByMes(Long ano, Long mes,Long cidade);

 //retorna a lista rankiada de pontos  por semana
 @Query(value = "select  *,sum(pon.pontos) as total ,user.nome from pontuacao pon\n" +
         "inner join user on user.id = pon.usuario\n" +
         " where pon.ano = :ano and pon.semana = :semana and pon.cidade = :cidade group by pon.usuario order by total desc", nativeQuery = true)
   List<Pontuacao> findPontosBySemana(Long ano, Long semana,Long cidade);
}
