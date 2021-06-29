package com.carros.api.desafioCumprido;


import com.carros.api.residuos.Residuo;
import com.carros.api.ruas.Rua;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

interface DesafioCumpridoRepository extends JpaRepository<DesafioCumprido, Long> {


    List<DesafioCumprido> findByUsuario(Long usuario);


    @Query(value = "SELECT * FROM desafio_cumprido WHERE usuario = :usuario and desafio = :desafio " ,nativeQuery = true)
    List<DesafioCumprido> findByDesafio(Long usuario, Long desafio);


    @Query(value = "select COUNT(id) as quant from desafio_cumprido where usuario = :usuario and desafio = :desafio", nativeQuery = true)
    double findSoma(Long usuario, Long desafio);


}
