package com.carros.api.ruas;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Arrays;
import java.util.List;

interface RuaRepository extends JpaRepository<Rua, Long> {
    List<Rua> findByCidadeAndBairro(Long cidade,Long bairro);

    @Query(value = "SELECT * FROM ruas WHERE cidade = :cidade and id = :id " ,nativeQuery = true)
    List<Rua> findByCidade(Long cidade, Long id);
}
