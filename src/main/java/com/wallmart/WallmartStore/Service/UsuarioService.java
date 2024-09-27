package com.wallmart.WallmartStore.Service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wallmart.WallmartStore.Repositories.UsuarioRepository;
import com.wallmart.WallmartStore.Entities.Usuario;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario agregarUsuario(Usuario usuario){
        return this.usuarioRepository.save(usuario);
    }

    public Object mostrarUsuarioPage(Integer page, Integer size){
       Pageable pageable = PageRequest.of(page,size);

        return this.usuarioRepository.findAll(pageable);
    }

    public void eliminarUsuario(Integer id){
        this.usuarioRepository.deleteById(id);
    }

    public Usuario modificarUsuario(Usuario usuario){
        return this.usuarioRepository.save(usuario);
    }

    public Optional<Usuario> mostrarUsuarioId(Integer id){
        return this.usuarioRepository.findById(id);
    }

    public Object verificarUsuario(String nombre, String contrasena){
        
        Optional<Usuario> usuarioExistente = this.usuarioRepository.findByNombreUsuario(nombre);
        if (usuarioExistente.isPresent()) {
            Usuario usuarioEncontrado = usuarioExistente.get();
            
            // Comparar la contraseña usando equals para verificar contenido
            if (usuarioEncontrado.getContrasena().equals(contrasena)) {
                return usuarioEncontrado;
            }
        }return null;

            

    }

    

    
    
}
