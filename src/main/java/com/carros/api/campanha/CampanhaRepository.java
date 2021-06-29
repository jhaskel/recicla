package com.carros.api.campanha;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

interface CampanhaRepository extends JpaRepository<Campanha, Long> {


    @Query(value = "select * from campanha  where cidade = :cidade", nativeQuery = true)
    List<Campanha> findLogisticaByCidade(Long cidade);

    @Query(value = "select * from campanha  where cidade = :cidade and tipo = :tipo ", nativeQuery = true)
    List<Campanha> findLogisticaByTipo(Long cidade, String tipo);
}
