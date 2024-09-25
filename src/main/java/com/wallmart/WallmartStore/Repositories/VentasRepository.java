package com.wallmart.WallmartStore.Repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.wallmart.WallmartStore.Entities.Ventas;

@Repository
public interface VentasRepository extends MongoRepository<Ventas, Integer> {

    
}
