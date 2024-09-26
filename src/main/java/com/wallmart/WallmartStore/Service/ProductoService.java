package com.wallmart.WallmartStore.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wallmart.WallmartStore.Entities.Producto;
import com.wallmart.WallmartStore.Repositories.ProductoRepository;

@Service
public class ProductoService {
    @Autowired

    //Este objeto controla el repositorio del producto
    private ProductoRepository productoRepository;


    public Producto agregarProducto(Producto producto){
        //el comando save guarda el producto en la bd
        return this.productoRepository.save(producto);

    }

    public List<Producto> obtenerProductos(Producto producto){

        return this.productoRepository.findAll();
    }

    public Object mostrarProductosPage(int page, int size){
        //hace una peticion para paginar 
        Pageable pageable = PageRequest.of(page,size);
        
        //utiliza el metodo sobrecargado de la clase ProductoRepository que hace que tenga
        //que recibir una lista de productos en formate Page
        return this.productoRepository.findAll(pageable);
    }

    public void eliminarProducto(Integer id){
        this.productoRepository.deleteById(id);
    }

    public Producto modificarProducto(Producto producto){
        return this.productoRepository.save(producto);
    }


}
