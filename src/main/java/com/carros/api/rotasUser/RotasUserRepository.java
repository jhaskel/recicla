package com.carros.api.rotasUser;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Arrays;
import java.util.List;

interface RotasUserRepository extends JpaRepository<RotasUser, Long> {



    @Query(value = "SELECT rtu.* ,rot.nome AS nomerota, rot.tipo AS tiporota from rotas_user rtu INNER JOIN rotas rot ON rot.id = rtu.rota WHERE rtu.user = :user",nativeQuery = true)
    List<RotasUser> findRotaByUser(Long user);

}
