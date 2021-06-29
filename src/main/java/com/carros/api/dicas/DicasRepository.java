package com.carros.api.dicas;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

interface DicasRepository extends JpaRepository<Dica, Long> {
    @Query(value = "select * from dica  order by id desc", nativeQuery = true)
    List<Dica> findAll2();

    @Query(value = "SELECT COUNT(dica.id) AS quant FROM dica \n" +
            "WHERE  dica.id NOT IN (SELECT idevento FROM favoritos WHERE icone = 3 ) ", nativeQuery = true)
    long findQuantLidas();

}
