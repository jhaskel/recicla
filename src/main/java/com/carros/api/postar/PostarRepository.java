package com.carros.api.postar;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Arrays;
import java.util.List;

interface PostarRepository extends JpaRepository<Postar, Long> {


    @Query(value = "SELECT pos.* ,user.nome AS donopost,user.url_foto AS donofoto\n" +
            "from postar pos \n" +
            "INNER JOIN user ON user.id = pos.usuario\n" +
            "WHERE pos.cidade = :cidade order by id desc",nativeQuery = true)
    List<Postar> findByCidade(Long cidade);

    @Query(value = "SELECT bri.* from postar bri \n" +
            "INNER JOIN favoritos fav ON fav.idevento = bri.id\n" +
            "WHERE bri.ativo = TRUE and fav.usuario = :usuario AND fav.icone = 4",nativeQuery = true)
    List<Postar> findByIdk(Long usuario);


    @Query(value = "SELECT COUNT(*) AS bricado FROM postar WHERE bricado = :usuario", nativeQuery = true)
    Long findPerfilBricado(Long usuario);

    @Query(value = "SELECT * from postar  WHERE  usuario = :usuario ",nativeQuery = true)
    List<Postar>  findByUsu(Long usuario);
}
