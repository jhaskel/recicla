package com.carros.api.qrcode;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QrcodeRepository extends JpaRepository<Qrcode, Long> {





    @Query(value = "select * from qrcode  where idloja = :idloja ORDER BY date desc", nativeQuery = true)
    List<Qrcode> findExtratoByIdloja(Long idloja);


    @Query(value = "select * from qrcode  where codigo = :codigo", nativeQuery = true)
    List<Qrcode> findExtratoByCodigo(String codigo);

    @Query(value = "select * from qrcode  where usuario = :usuario and tipo = :tipo ORDER BY date desc", nativeQuery = true)
    List<Qrcode> findCupomByUsuario(Long usuario, String tipo);
}
