package com.carros.api.logistica;


import com.carros.api.pontua.Pontua;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Arrays;
import java.util.List;

interface LogisticaRepository extends JpaRepository<Logistica, Long> {


    @Query(value = "select * from logistica  where cidade = :cidade", nativeQuery = true)
    List<Logistica> findLogisticaByCidade(Long cidade);


    @Query(value = "select * from logistica  where idloja = :idloja", nativeQuery = true)
    List<Logistica> findLogisticaByIdLoja(Long idloja);

    @Query(value = "select * from logistica  where cidade = :cidade and tipo = :tipo ", nativeQuery = true)
    List<Logistica> findLogisticaByTipo(Long cidade,String tipo);

}
