package com.carros.api.coletando.coletacrud;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Arrays;
import java.util.List;

interface ColetacrudRepository extends JpaRepository<Coletacrud, Long> {

    @Query(value = "SELECT col.* , rot.nome as nomerota, emp.nome as nomeempresa, rot.tipo AS tiporota FROM coletando col INNER JOIN rotas rot ON rot.id = col.idrota INNER JOIN caminhao cam ON cam.id = col.idcaminhao INNER JOIN empresa emp ON emp.id = cam.idempresa  WHERE col.cidade = :cidade AND col.ativo =true and col.dia = :dia",nativeQuery = true)
    List<Coletacrud> findByCidade(Long cidade,String dia);
}
