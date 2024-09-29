package com.wallmart.WallmartStore.Service;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

    public Optional<Usuario> mostrarUsuarioId(Integer id){
        return this.usuarioRepository.findById(id);
    }

    
    public Object verificarUsuario(String nombreUsuario, String contrasena){
        
        //se crea un objeto optional de usuario, el cual contiene el metodo findByNombreUsuario
        Optional<Usuario> usuarioExistente = this.usuarioRepository.findByNombreUsuario(nombreUsuario);

        //condicional que verifica si el usuario existe
        if (usuarioExistente.isPresent()) {
            //en caso de si existir se crea un Objeto Usuario llamado usuario encontrado y se le asgina todo el body del usuario existente.
            Usuario usuarioEncontrado = usuarioExistente.get();
            
            // Comparar la contraseña usando equals para verificar contenido
            if (usuarioEncontrado.getContrasena().equals(contrasena)) {
                //si la contrasena del usuario encontrado es igual a la contrasena que se puso, se retorna el usuario
                return usuarioEncontrado;
            }
        }return null;

            

    }

    

    
    
}
