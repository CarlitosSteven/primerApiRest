package com.wallmart.WallmartStore.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wallmart.WallmartStore.Entities.Ventas;
import com.wallmart.WallmartStore.Service.VentasService;

@RestController //API REST
public class VentaController {
    @Autowired
    private VentasService ventaService;

    @PostMapping("/agregarVenta") //endpoint tipo POST
    public Object agregarVenta(@RequestBody Ventas ventas){
        return this.ventaService.agregarVenta(ventas);
    }

    @GetMapping("/obtenerVentas")
    public Object obtenerVentas(){
        return this.ventaService.obtenerVentas();
    }

}
