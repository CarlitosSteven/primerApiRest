//repositorios
package com.wallmart.WallmartStore.Repositories;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.wallmart.WallmartStore.Entities.Usuario;

import java.util.Optional;

//paginar
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UsuarioRepository extends MongoRepository<Usuario, Integer> {
    Page<Usuario> findAll(Pageable pageable);

    
    boolean existsByNombreUsuario(String nombreUsuario);

    Optional<Usuario> findByNombreUsuario(String nombreUsuario);

    
}
