package com.carros.api.apoiadoresAnuncio;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

interface ApoiadoresAnuncioRepository extends JpaRepository<ApoiadoresAnuncio, Long> {


    @Query(value = "select * from apoiadores_anuncio anu\n" +
            "INNER JOIN apoiadores apo ON apo.id = anu.apoiador\n" +
            "WHERE anu.ativo = TRUE AND anu.somentecidade = false AND aplicativo = :aplicativo ORDER BY RAND() LIMIT 1", nativeQuery = true)
    List<ApoiadoresAnuncio> findByAplicativo(Long aplicativo);
}
