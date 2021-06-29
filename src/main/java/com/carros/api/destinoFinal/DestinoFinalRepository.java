package com.carros.api.destinoFinal;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

interface DestinoFinalRepository extends JpaRepository<DestinoFinal, Long> {


    List<DestinoFinal> findByTitle(String title);


}
