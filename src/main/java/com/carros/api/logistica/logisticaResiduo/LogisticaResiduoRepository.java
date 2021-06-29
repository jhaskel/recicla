package com.carros.api.logistica.logisticaResiduo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

interface LogisticaResiduoRepository extends JpaRepository<LogisticaResiduo, Long> {


    @Query(value = "SELECT * FROM logistica_tipo t WHERE NOT EXISTS (SELECT * FROM logistica l WHERE l.tipo= t.nome AND l.idloja = :id)", nativeQuery = true)
    List<LogisticaResiduo> findAlla(Long id);


    @Query(value = "SELECT * FROM logistica_residuo order by nome", nativeQuery = true)
    List<LogisticaResiduo> findAlll();


    @Query(value = "SELECT *  FROM logistica logi \n" +
            "INNER JOIN logistica_tipo tip ON tip.nome = logi.tipo \n" +
            "INNER JOIN logistica_residuo res ON res.id_tipo = tip.id\n" +
            "INNER JOIN parceiro par ON par.id = logi.idloja\n" +
            " WHERE res.nome = :nome  AND logi.cidade= :cidade  \n" +
            " GROUP BY tip.nome", nativeQuery = true)
    List<LogisticaResiduo> findLogisticaByNome(Long cidade,String nome);



}
