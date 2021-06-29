package com.carros.api.contato;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Arrays;
import java.util.List;

public interface ContatoRepository extends JpaRepository<Contato, Long> {


    @Query(value = "select * from contato  ORDER BY date desc", nativeQuery = true)
    List<Contato> findAllContatos();

    @Query(value = "select * from contato  where setor = :setor ORDER BY date desc", nativeQuery = true)
    List<Contato> findContatoBySetor(Long setor);

    @Query(value = "select * from contato  where cidade = :cidade ORDER BY date desc", nativeQuery = true)
    List<Contato> findContatoByCidade(Long cidade);
}
