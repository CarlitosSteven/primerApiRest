package com.wallmart.WallmartStore.Repositories;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

import com.wallmart.WallmartStore.Entities.Venta;

//Repositorio que contiene metodos de mongoDB
@Repository
public interface VentaRepository extends MongoRepository<Venta, Integer> {

    Page<Venta> findAll(Pageable pageable);
}
