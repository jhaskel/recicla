package com.carros.api.rotas;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Arrays;
import java.util.List;

interface RotasRepository extends JpaRepository<Rotas, Long> {

    @Query(value = "SELECT * from rotas where ativo = true and cidade = :cidade",nativeQuery = true)
    List<Rotas> findByCidade(Long cidade);

}
