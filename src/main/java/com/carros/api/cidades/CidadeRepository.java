package com.carros.api.cidades;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.BitSet;
import java.util.List;
import java.util.Optional;

interface CidadeRepository extends JpaRepository<Cidade, Long> {

    List<Cidade> findByCidade(Long cidade);
}
