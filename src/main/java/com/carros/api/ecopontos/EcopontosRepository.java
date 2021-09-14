package com.carros.api.ecopontos;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

interface EcopontosRepository extends JpaRepository<Ecopontos, Long> {
    @Query(value = "select * from ecopontos  order by id desc", nativeQuery = true)
    List<Ecopontos> findAll2();

    @Query(value = "select * from ecopontos where cidade = :cidade  order by id desc", nativeQuery = true)
    List<Ecopontos> findCidade(Long cidade);



}
