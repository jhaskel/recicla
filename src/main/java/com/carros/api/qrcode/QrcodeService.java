package com.carros.api.qrcode;

import com.carros.api.infra.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QrcodeService {

    @Autowired
    private QrcodeRepository rep;


    public List<QrcodeDTO> getPontuacaos() {
        return rep.findAll().stream().map(QrcodeDTO::create).collect(Collectors.toList());

    }

    public QrcodeDTO getPontuacaoById(Long id) {
        Optional<Qrcode> pontuacao = rep.findById(id);
        return pontuacao.map(QrcodeDTO::create).orElseThrow(() -> new ObjectNotFoundException("Pontuacao não encontrado"));
    }



    public List<QrcodeDTO> getExtratoByIdloja(Long idloja) {
        return rep.findExtratoByIdloja(idloja).stream().map(QrcodeDTO::create).collect(Collectors.toList());
    }



    public List<QrcodeDTO> getExtratoByQrcode(String qrcode) {
        return rep.findExtratoByQrcode(qrcode).stream().map(QrcodeDTO::create).collect(Collectors.toList());
    }


    public QrcodeDTO insert(Qrcode pontuacao) {
        Assert.isNull(pontuacao.getId(),"Não foi possível inserir o registro");
        return QrcodeDTO.create(rep.save(pontuacao));
    }
    public List<QrcodeDTO> getCupomByUsuario(Long usuario, String tipo) {
        return rep.findCupomByUsuario(usuario,tipo).stream().map(QrcodeDTO::create).collect(Collectors.toList());
    }

    public QrcodeDTO update(Qrcode pontuacao, Long usuario) {
        Assert.notNull(usuario,"Não foi possível atualizar o registro");

        // Busca o carro no banco de dados
        Optional<Qrcode> optional = rep.findById(usuario);
        if(optional.isPresent()) {
            Qrcode db = optional.get();
            // Copiar as propriedades
            db.setQrcode(pontuacao.getQrcode());
            db.setValor(pontuacao.getValor());
            db.setAtivo(pontuacao.getAtivo());

       //     System.out.println("Pontuacao id " + db.getId());

            // Atualiza a pontuacao
            rep.save(db);

            return QrcodeDTO.create(db);
        } else {
            return null;
            //throw new RuntimeException("Não foi possível atualizar o registro");
        }
    }

    public void delete(Long id) {
        rep.deleteById(id);
    }



}
