package com.wallmart.WallmartStore.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wallmart.WallmartStore.Entities.Ventas;
import com.wallmart.WallmartStore.Repositories.VentasRepository;

@Service
public class VentasService {
    @Autowired // sustitye el constructor por defecto
    /*private VentasRepository ventasRepository;
    public VentasService( VentasRepository ventasRepository){
        ventasRepository = this.ventasRepository;
    } */
    private VentasRepository ventasRepository;

    public Ventas agregarVenta(Ventas venta){
        return this.ventasRepository.save(venta);
    }

    public List<Ventas> obtenerVentas(){
        return this.ventasRepository.findAll();
    }
}
