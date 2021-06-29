package com.carros.api.logistica.logisticaTipo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

interface LogisticaTipoRepository extends JpaRepository<LogisticaTipo, Long> {


    @Query(value = "SELECT * FROM logistica_tipo t WHERE NOT EXISTS (SELECT * FROM logistica l WHERE l.tipo= t.nome AND l.idloja = :id)", nativeQuery = true)
    List<LogisticaTipo> findAlla(Long id);


}
