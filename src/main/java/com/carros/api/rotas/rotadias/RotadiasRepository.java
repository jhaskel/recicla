package com.carros.api.rotas.rotadias;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Arrays;
import java.util.List;

interface RotadiasRepository extends JpaRepository<Rotadias, Long> {

    @Query(value = "SELECT * from rotadias where ativo = true and rota = :rota",nativeQuery = true)
    List<Rotadias> findByRota(Long rota);

    @Query(value = "SELECT rotd.*,dias.dia AS nomedia, rot.nome AS nomerota,rot.tipo AS nometipo, rot.periodo AS nomeperiodo,bai.nome AS nomebairro\n" +
            " FROM rotadias rotd  \n" +
            " INNER JOIN dias ON dias.id = rotd.dia\n" +
            " INNER JOIN rotas rot ON rot.id = rotd.rota\n" +
            " INNER JOIN rotabairros rotb ON rotb.rota = rot.id\n" +
            " INNER JOIN bairro bai ON bai.id = rotb.bairro\n" +
            "\n" +
            " WHERE rotb.bairro = :bairro and rotb.ativo = 1" +
            " \n" +
            " ORDER BY rotd.dia",nativeQuery = true)
    List<Rotadias> findByBairro(Long bairro);


}
