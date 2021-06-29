package com.carros.api.Teste;


import com.carros.api.rotas.Rotas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Arrays;
import java.util.List;

interface TesteRepository extends JpaRepository<Teste, Long> {

    @Query(value = "SELECT * from teste where id = :id",nativeQuery = true)
    List<Teste>  findTesteById(Long id);
}
