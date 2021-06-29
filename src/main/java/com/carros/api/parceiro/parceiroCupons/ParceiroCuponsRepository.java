package com.carros.api.parceiro.parceiroCupons;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ParceiroCuponsRepository extends JpaRepository<ParceiroCupons, Long> {


    @Query(value = "select * from parceiro_cupons  where  idloja = :idloja ORDER BY ativo desc, id desc", nativeQuery = true)
    List<ParceiroCupons>  findParceiroByIdloja(Long idloja);
}
