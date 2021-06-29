package com.carros.api.home.homecidade;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Arrays;
import java.util.List;

interface HomecidadeRepository extends JpaRepository<Homecidade, Long> {
    @Query(value = "SELECT hci.*, home.title AS titulo, home.image AS icone from homecidade hci INNER JOIN home ON home.id = hci.home where hci.cidade = :cidade and hci.ativo = true order by hci.posicao ",nativeQuery = true)
    List<Homecidade> findByAlgo(Long cidade);

}
