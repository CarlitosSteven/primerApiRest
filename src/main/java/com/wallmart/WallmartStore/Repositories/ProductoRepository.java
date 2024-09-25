package com.wallmart.WallmartStore.Repositories;
// importa los componentes necesarios para paginar
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
//--------------------------------------------------------------
import org.springframework.stereotype.Repository;
import com.wallmart.WallmartStore.Entities.Producto;


import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface ProductoRepository extends MongoRepository<Producto, Integer>{
    //find all es el metodo select y en este caso esta sobrecargado
    Page<Producto> findAll(Pageable pageable);
}
