package com.carros.api.classes;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Arrays;
import java.util.BitSet;
import java.util.Collection;
import java.util.List;

interface ClasseRepository extends JpaRepository<Classe, Long> {

    @Query(value = "SELECT* from classe",nativeQuery = true)
    List<ClasseDTO> findUsersAndRoles();

    @Query(value = "select u Classe, r.nome u inner join u.cidade r where tipo = ?1",nativeQuery = true)
    List<Classe> findByTipo(String tipo);

    @Query(value = "SELECT * from classe",nativeQuery = true)
    List<Classe> findAlll();

}
