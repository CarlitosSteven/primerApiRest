package com.wallmart.WallmartStore.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wallmart.WallmartStore.Entities.Venta;
import com.wallmart.WallmartStore.Service.VentaService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController //API REST
public class VentaController {
    @Autowired
    private VentaService VentaService;

    //Se utiliza para mapear solicitudes HTTP POST a métodos específicos en un controlador.
    //Indica que el método del controlador debe ser invocado cuando se realiza una solicitud HTTP
    @PostMapping("/agregarVenta") //endpoint tipo POST
    public Object agregarVenta(@RequestBody Venta Venta){
        return this.VentaService.agregarVenta(Venta);
    }

    
    @GetMapping("/obtenerVenta")
    public Object obtenerVenta(){
        return this.VentaService.obtenerVenta();
    }

    @GetMapping("/obtenerVentas") 
    //El @RequesParam se utiliza para decir que los parametros se obtendran de la consulta en la url de la solicitud HTTP
    //y les da un valor por defecto en caso de que no se les de en la consulta.
    public Object obtenerVentas(@RequestParam(required = false, defaultValue = "0") Integer page, @RequestParam(required = false, defaultValue = "10") Integer size){
        return this.VentaService.obtenerVentaPage(page, size);
    }

}
