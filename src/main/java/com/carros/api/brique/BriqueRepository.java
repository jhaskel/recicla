package com.carros.api.brique;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Arrays;
import java.util.List;

interface BriqueRepository extends JpaRepository<Brique, Long> {


    @Query(value = "SELECT * from brique where  cidade = :cidade order by id desc",nativeQuery = true)
    List<Brique> findByCidade(Long cidade);

    @Query(value = "SELECT bri.* from brique bri \n" +
            "INNER JOIN favoritos fav ON fav.idevento = bri.id\n" +
            "WHERE bri.ativo = TRUE and fav.usuario = :usuario AND fav.icone = 4",nativeQuery = true)
    List<Brique> findByIdk(Long usuario);




    @Query(value = "SELECT COUNT(*) AS bricado FROM brique WHERE bricado = :usuario", nativeQuery = true)
    Long findPerfilBricado(Long usuario);
}
