package com.carros.api.coletando;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Arrays;
import java.util.List;

interface ColetandoRepository extends JpaRepository<Coletando, Long> {
    @Query(value = "SELECT * from coletando where id = :id ",nativeQuery = true)
    List<Coletando> findByAlgo(Long id);

    @Query(value = "SELECT * from coletando where ativo = 1 and  usuario = :usuario order by id desc limit 1 ",nativeQuery = true)
    List<Coletando> findByUsuario(Long usuario);



    @Query(value = "SELECT COUNT(*) as quant " +
            "FROM coletando col " +
            "INNER JOIN rotabairros rot ON rot.rota = col.idrota  " +
            "WHERE  col.ativo = true AND col.cidade = :cidade AND rot.bairro = :bairro and col.dia = :dia", nativeQuery = true)
    double findSomaRotaDia(Long cidade,Long bairro,String dia);


    // @Query(value = "SELECT col.* , rot.nome as nomerota, emp.nome as nomeempresa FROM coletando col INNER JOIN rotas rot ON rot.id = col.idrota INNER JOIN caminhao cam ON cam.id = col.idcaminhao INNER JOIN empresa emp ON emp.id = cam.idempresa  WHERE col.cidade = 1 AND col.ativo =true",nativeQuery = true)
  //  List<Coletando> findByCidade(Long cidade);
}
