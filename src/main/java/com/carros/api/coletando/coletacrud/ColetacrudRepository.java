package com.carros.api.coletando.coletacrud;


import com.carros.api.coletando.Coletando;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Arrays;
import java.util.List;

interface ColetacrudRepository extends JpaRepository<Coletacrud, Long> {

    @Query(value = "SELECT col.* , rot.nome as nomerota, emp.nome as nomeempresa, rot.tipo AS tiporota \n" +
            "FROM coletando col \n" +
            "INNER JOIN rotas rot ON rot.id = col.idrota \n" +
            "INNER JOIN caminhao cam ON cam.id = col.idcaminhao \n" +
            "INNER JOIN empresa emp ON emp.id = cam.idempresa \n" +
            "INNER JOIN rotabairros rtb ON rtb.rota = rot.id\n" +
            "INNER JOIN bairro bai ON bai.id = rtb.bairro \n" +
            "WHERE bai.cidade = :cidade  and col.dia = :dia and bai.id=:bairro\n" +
            "GROUP BY col.id ORDER BY col.id desc",nativeQuery = true)
    List<Coletacrud> findByCidade(Long cidade,String dia,Long bairro);


    @Query(value = "SELECT col.*, col.dia as nomerota, col.dia as nomeempresa, col.dia AS tiporota from coletando col where col.ativo = 1 and  col.usuario = :usuario and col.dia = :dia order by col.id desc limit 1 ",nativeQuery = true)
    List<Coletacrud> findUsuarioDia(Long usuario, String dia);
}
