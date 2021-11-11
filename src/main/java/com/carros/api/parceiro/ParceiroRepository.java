package com.carros.api.parceiro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Arrays;
import java.util.List;

public interface ParceiroRepository extends JpaRepository<Parceiro, Long> {




    @Query(value = "select * from parceiro  where cidade = :cidade and ativo = true  ORDER BY id desc", nativeQuery = true)
    List<Parceiro>  findParceiroByCidade(Long cidade);

    @Query(value = "select * from parceiro  where id = :id ", nativeQuery = true)
    List<Parceiro> findParceiroById(Long id);
}
