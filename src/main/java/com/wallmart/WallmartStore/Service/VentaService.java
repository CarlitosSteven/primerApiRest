package com.wallmart.WallmartStore.Service;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wallmart.WallmartStore.Entities.Venta;
import com.wallmart.WallmartStore.Repositories.VentaRepository;

@Service
public class VentaService {
    @Autowired // sustitye el constructor por defecto
    /*private VentaRepository VentaRepository;
    public VentaService( VentaRepository VentaRepository){
        VentaRepository = this.VentaRepository;
    } */
    private VentaRepository VentaRepository;

    public Venta agregarVenta(Venta venta){
        //Simula un Id autoincremental
        Long ultimoId = this.VentaRepository.count(); //encuentra el ultimo ID
        venta.setId(ultimoId.intValue()+1); //el ultimo Id + 1
        //guarda la venta en el repositorio
        return this.VentaRepository.save(venta);
    }

    public List<Venta> obtenerVenta(){
        return this.VentaRepository.findAll();
    }

    public Optional<Venta> obtenerVentaId(Integer id){
        return this.VentaRepository.findById(id);
    }

    //Paginando
    public Page<Venta> obtenerVentaPage(int page, int size){
        Pageable pageable = PageRequest.of(page, size);

        return this.VentaRepository.findAll(pageable);
       
    }
}
