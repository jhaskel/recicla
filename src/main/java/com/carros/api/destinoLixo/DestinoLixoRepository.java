package com.carros.api.destinoLixo;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.BitSet;
import java.util.List;

interface DestinoLixoRepository extends JpaRepository<DestinoLixo, Long> {


    List<DestinoLixo> findByTitle(String title);


}
