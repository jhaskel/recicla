package com.carros.api.desafios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DesafioRepository extends JpaRepository<Desafio, Long> {

    List<Desafio> findByTipo(String tipo);

    @Query(value = " SELECT * FROM desafio\n" +
            " WHERE cidade = :cidade and desafio.id NOT IN (SELECT desafio FROM desafio_cumprido WHERE usuario = :usuario) order by created desc ",nativeQuery = true)
    List<Desafio> findByAlgo(Long cidade,Long usuario);
}
