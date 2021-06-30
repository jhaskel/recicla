package com.carros.api.favoritos;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Arrays;
import java.util.List;

interface FavoritosRepository extends JpaRepository<Favoritos, Long> {

    @Query(value = "SELECT * from favoritos where  ativo = true and usuario = :usuario and icone = :icone and idevento = :idevento",nativeQuery = true)
    List<Favoritos> findByCidade(Long usuario,Long icone,Long idevento);


    @Query(value = "SELECT * from favoritos where  ativo = true and usuario = :usuario and icone = :icone ",nativeQuery = true)
    List<Favoritos> findByIcone(Long usuario, Long icone);

    @Query(value = "SELECT * from favoritos where  usuario = :usuario and icone = :icone",nativeQuery = true)
    List<Favoritos> findByUsuarioIcone(Long usuario, Long icone);

    @Query(value = "SELECT * from favoritos where  usuario = :usuario and icone = :icone and idevento = :idevento",nativeQuery = true)
    List<Favoritos> findByFavoritosPostar(Long usuario, Long icone,Long idevento);

    @Query(value = "select count(id) as quant from favoritos where  ativo = true and usuario = :usuario and icone = :icone and idevento = :idevento", nativeQuery = true)
    double findSoma(Long usuario, Long icone, Long idevento);

    @Query(value = "select count(id) as quant from favoritos where  ativo = true and usuario = :usuario and icone = :icone ", nativeQuery = true)
    double findQuant(Long usuario, Long icone);


    @Query(value = "select count(id) from favoritos where  ativo = true and usuario = :usuario and icone = :icone", nativeQuery = true)
    Long findQuantLidas(Long usuario,Long icone);
}
