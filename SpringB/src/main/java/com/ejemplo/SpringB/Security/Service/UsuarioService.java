package com.ejemplo.SpringB.Security.Service;

import com.ejemplo.SpringB.Security.Entity.Usuario;
import com.ejemplo.SpringB.Security.Repository.IUsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class UsuarioService {
    @Autowired
    IUsuarioRepository iusuarioRepository;

    public Optional<Usuario> getByNombreUsuario(String nombreUsuario){
        return iusuarioRepository.findByNombreUsuario(nombreUsuario);
    }

    public boolean existByNombreUsuario(String nombreUsuario){
        return iusuarioRepository.existByNombreUsuario(nombreUsuario);
    }

    public boolean existByEmail(String email){
        return iusuarioRepository.existByEmail(email);
    }

    public void save(Usuario usuario){
        iusuarioRepository.save(usuario);
    }
}
