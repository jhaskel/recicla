package com.carros.api.caminhao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Arrays;
import java.util.List;

interface CaminhaoRepository extends JpaRepository<Caminhao, Long> {

    @Query(value = "SELECT * from caminhao where idempresa = :idempresa ",nativeQuery = true)
    List<Caminhao> findByIdEmpresa(Long idempresa);

}
