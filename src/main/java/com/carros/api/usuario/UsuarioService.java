package com.carros.api.usuario;

import com.carros.api.infra.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository rep;
    public List<UsuarioDTO> getUsuarios() {
        List<UsuarioDTO> list = rep.findAll().stream().map(UsuarioDTO::create).collect(Collectors.toList());
        return list;
    }

    public UsuarioDTO getUsuarioById(Long id) {
        Optional<Usuario> usuario = rep.findById(id);
        return usuario.map(UsuarioDTO::create).orElseThrow(() -> new ObjectNotFoundException("Carro não encontrado"));
    }



    public double QuantNoticia(Long usuario){
        return rep.QuantNoticia(usuario);
    }


    public Long QuantEmail(String email){
        return rep.QuantEmail(email);
    }


    public UsuarioDTO insert(Usuario usuario) {
        Assert.isNull(usuario.getId(),"Não foi possível inserir o registro");
        return UsuarioDTO.create(rep.save(usuario));
    }



    public UsuarioDTO update(Usuario usuario, Long id) {
        Assert.notNull(id,"Não foi possível atualizar o registro");

        // Busca o usuario no banco de dados
        Optional<Usuario> optional = rep.findById(id);
        if(optional.isPresent()) {
            Usuario db = optional.get();
            // Copiar as propriedades
          //  db.setEmail(usuario.getEmail());
            db.setLogin(usuario.getLogin());
            db.setNome(usuario.getNome());
            db.setSenha(usuario.getSenha());
            db.setUrlFoto(usuario.getUrlFoto());
          //  db.setCidade(usuario.getCidade());
            db.setBairro(usuario.getBairro());
            db.setRua(usuario.getRua());
            db.setCelular(usuario.getCelular());
            db.setNascimento(usuario.getNascimento());
            db.setGenero(usuario.getGenero());
            db.setDistancia(usuario.getDistancia());
            db.setLocal(usuario.getLocal());
            db.setLatitude(usuario.getLatitude());
            db.setLongitude(usuario.getLongitude());
            db.setTipo(usuario.getTipo());
            db.setEmpresa(usuario.getEmpresa());
            db.setAddress(usuario.getAddress());

            db.setAtivo(usuario.getAtivo());
            db.setLogadoem(usuario.getLogadoem());



            System.out.println("Usuario id " + db.getId());

            // Atualiza o usuario
            rep.save(db);
            return UsuarioDTO.create(db);
        } else {
            return null;
            //throw new RuntimeException("Não foi possível atualizar o registro");
        }
    }

    public void delete(Long id) {
        rep.deleteById(id);
    }


    public List<UsuarioDTO> getTesteById(Long id) {
        return rep.findTesteById(id).stream().map(UsuarioDTO::create).collect(Collectors.toList());
    }


    public List<UsuarioDTO> getTesteByEmail(String email) {
        return rep.findTesteByEmail(email).stream().map(UsuarioDTO::create).collect(Collectors.toList());
    }


}
