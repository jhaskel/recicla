package com.carros.api.residuos;


import com.carros.api.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.BitSet;
import java.util.List;
import java.util.Optional;

interface ResiduoRepository extends JpaRepository<Residuo, Long> {
    List<Residuo> findByTipo(String tipo);

    List<Residuo> findByYear(Long year);

    @Query(value = "select *,sum(quantidade) as quant from residuos where year = :year and cidade = :cidade group by tipo", nativeQuery = true)
    List<Residuo> findByCidadeAndYear(Long cidade, Long year);

    @Query(value = "select * from residuos where year = :year  ", nativeQuery = true)
    Optional<Residuo> findByTotal(Long year);

    @Query(value = "select sum(quantidade) as quant from residuos where year = :year and cidade = :cidade", nativeQuery = true)
    double findSoma(Long year, Long cidade);

    @Query(value = "select *,  sum(case when year = :year-1 and cidade = :cidade  then quantidade end) as quant, sum(case when year = :year and cidade =:cidade then quantidade end) as quant2 from residuos  where cidade = :cidade group by id_destino", nativeQuery = true)
    List<Residuo> findByDestino(Long cidade, Long year);


    @Query(value = "select *,  sum(case when year = :year-1 and cidade = :cidade  then quantidade end) as quant, sum(case when year = :year and cidade =:cidade then quantidade end) as quant2 from residuos  where cidade = :cidade group by tipo", nativeQuery = true)
    List<Residuo> findMetas(Long cidade, Long year);
}
