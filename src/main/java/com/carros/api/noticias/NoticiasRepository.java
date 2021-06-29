package com.carros.api.noticias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Arrays;
import java.util.List;

interface NoticiasRepository extends JpaRepository<Noticias, Long> {

    @Query(value = "SELECT * from noticias where cidade = :cidade and ativo = true order by created desc",nativeQuery = true)
    List<Noticias> findByAlgo(Long cidade);



    @Query(value = "SELECT COUNT(*) as quant  FROM noticias WHERE  cidade = :cidade ", nativeQuery = true)
    double QuantNoticia(Long cidade);


}
