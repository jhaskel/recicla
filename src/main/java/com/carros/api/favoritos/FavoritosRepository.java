package com.carros.api.favoritos;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

interface FavoritosRepository extends JpaRepository<Favoritos, Long> {

    @Query(value = "SELECT * from favoritos where  ativo = true and usuario = :usuario and tipo = :tipo and idevento = :idevento",nativeQuery = true)
    List<Favoritos> findByCidade(Long usuario,String tipo,Long idevento);


    @Query(value = "SELECT * from favoritos where  ativo = true and usuario = :usuario and tipo = :tipo ",nativeQuery = true)
    List<Favoritos> findByIcone(Long usuario, String tipo);

    @Query(value = "SELECT * from favoritos where  usuario = :usuario and tipo = :tipo",nativeQuery = true)
    List<Favoritos> findByUsuarioIcone(Long usuario, String tipo);

    @Query(value = "SELECT * from favoritos where  usuario = :usuario and tipo = :tipo and idevento = :idevento",nativeQuery = true)
    List<Favoritos> findByFavoritosPostar(Long usuario, String tipo,Long idevento);

    @Query(value = "select count(id) as quant from favoritos where  ativo = true and usuario = :usuario and tipo = :tipo and idevento = :idevento", nativeQuery = true)
    double findSoma(Long usuario, String tipo, Long idevento);

    @Query(value = "select count(id) as quant from favoritos where  ativo = true and usuario = :usuario and tipo = :tipo ", nativeQuery = true)
    double findQuant(Long usuario, String tipo);


    @Query(value = "select count(id) from favoritos where  ativo = true and usuario = :usuario and tipo = :tipo", nativeQuery = true)
    Long findQuantLidas(Long usuario,String tipo);
}
