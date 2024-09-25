package com.wallmart.WallmartStore.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wallmart.WallmartStore.Entities.Venta;
import com.wallmart.WallmartStore.Service.VentaService;

@RestController //API REST
public class VentaController {
    @Autowired
    private VentaService Ventaervice;

    @PostMapping("/agregarVenta") //endpoint tipo POST
    public Object agregarVenta(@RequestBody Venta Venta){
        return this.Ventaervice.agregarVenta(Venta);
    }

    /* 
    @GetMapping("/obtenerVenta")
    public Object obtenerVenta(){
        return this.Ventaervice.obtenerVenta();
    }*/

    @GetMapping("/obtenerVentas")
    public Object obtenerVentas(@RequestParam(required = false, defaultValue = "0") Integer page, @RequestParam(required = false, defaultValue = "10") Integer size){
        return this.Ventaervice.obtenerVentaPage(page, size);
    }

}
