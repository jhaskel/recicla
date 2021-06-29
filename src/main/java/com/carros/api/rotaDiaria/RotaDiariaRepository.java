package com.carros.api.rotaDiaria;

import com.carros.api.pontua.Pontua;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Arrays;
import java.util.List;

interface RotaDiariaRepository extends JpaRepository<RotaDiaria, Long> {

    @Query(value = "select * from rota_diaria  where dia = :dia ORDER BY id desc", nativeQuery = true)
    List<RotaDiaria> findRotaByDia(Long dia);

    @Query(value = "select * from rota_diaria  where semana = :semana and ano = :ano ORDER BY id desc", nativeQuery = true)
    List<RotaDiaria> findRotaBySemana(Long semana, Long ano);

    @Query(value = "select * from rota_diaria  where idrota = :idrota ORDER BY id desc", nativeQuery = true)
    List<RotaDiaria> findRotaByIdrota(Long idrota);

    @Query(value = "select * from rota_diaria  where mes = :mes and ano = :ano ORDER BY id desc", nativeQuery = true)
    List<RotaDiaria> findRotaByMes(Long mes, Long ano);

    @Query(value = "select * from rota_diaria  where ano = :ano ORDER BY id desc", nativeQuery = true)
    List<RotaDiaria> findRotaByAno(Long ano);

    @Query(value = "select * from rota_diaria  where idempresa = :idempresa ORDER BY id desc", nativeQuery = true)
    List<RotaDiaria> findRotaByIdempresa(Long idempresa);

    @Query(value = "select * from rota_diaria  where idcaminhao = :idcaminhao ORDER BY id desc", nativeQuery = true)
    List<RotaDiaria> findRotaByIdcaminhao(Long idcaminhao);

    @Query(value = "select * from rota_diaria  where usuario = :usuario ORDER BY id desc", nativeQuery = true)
    List<RotaDiaria> findRotaByUsuario(Long usuario);

    @Query(value = "select * from rota_diaria  where idcoleta = :idcoleta ORDER BY id desc", nativeQuery = true)
    List<RotaDiaria> findRotaByIdcoleta(Long idcoleta);



}
