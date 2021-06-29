package com.carros.api.rotas.rotabairros;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Arrays;
import java.util.List;

interface RotabairrosRepository extends JpaRepository<Rotabairros, Long> {

    @Query(value = "SELECT * from rotabairros where ativo = true and rota = :rota",nativeQuery = true)
    List<Rotabairros> findByRota(Long rota);


    @Query(value = "SELECT * from rotabairros where ativo = true and bairro = :bairro",nativeQuery = true)
    List<Rotabairros>findByBairro(Long bairro);

}

