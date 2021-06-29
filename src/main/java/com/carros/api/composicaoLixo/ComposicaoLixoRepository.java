package com.carros.api.composicaoLixo;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

interface ComposicaoLixoRepository extends JpaRepository<ComposicaoLixo, Long> {


    List<ComposicaoLixo> findByTitle(String title);



}
