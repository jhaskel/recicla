package com.carros.api.bairro;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Arrays;
import java.util.List;

interface BairroRepository extends JpaRepository<Bairro, Long> {
    List<Bairro> findByCidade(Long cidade);

    @Query(value = "select * from bairro  where cidade = :cidade and id = :id", nativeQuery = true)
    List<Bairro> findBaiByCidade(Long cidade, Long id);
}
