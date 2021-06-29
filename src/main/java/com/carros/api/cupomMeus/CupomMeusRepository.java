package com.carros.api.cupomMeus;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Arrays;
import java.util.List;

public interface CupomMeusRepository extends JpaRepository<CupomMeus, Long> {




    @Query(value = "select * from cupom_meus  where usuario = :usuario ORDER BY hoje desc", nativeQuery = true)
    List<CupomMeus> findExtratoByUsuario(Long usuario);


    @Query(value = "select * from cupom_meus  where idloja = :idloja ORDER BY date desc", nativeQuery = true)
    List<CupomMeus> findExtratoByIdloja(Long idloja);


    @Query(value = "select * from cupom_meus  where codigo = :codigo", nativeQuery = true)
    List<CupomMeus> findExtratoByCodigo(String codigo);

    @Query(value = "select * from cupom_meus  where usuario = :usuario and tipo = :tipo ORDER BY date desc", nativeQuery = true)
    List<CupomMeus> findCupomByUsuario(Long usuario, String tipo);
}
