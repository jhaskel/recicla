package com.carros.api.imprevistos;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

interface ImprevistosRepository extends JpaRepository<Imprevistos, Long> {
    @Query(value = "SELECT * from imprevistos where dia = :dia and coleta = :coleta",nativeQuery = true)
    List<Imprevistos> findByAlgo(String dia,Long coleta);

}
