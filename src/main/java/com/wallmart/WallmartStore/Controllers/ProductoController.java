package com.wallmart.WallmartStore.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.wallmart.WallmartStore.Service.ProductoService;
import com.wallmart.WallmartStore.Entities.Producto;


@RestController //Api rest: se utiliza para definir una clase como un controlador web donde cada método devuelve datos en lugar de una vista. //manejará solicitudes HTTP (GET, POST, PUT, DELETE, etc.)
                
public class ProductoController {
    @Autowired

    private ProductoService productoService; //objeto de la clase servicio

    @PostMapping("/agregarProducto")
    public Object agregarProducto(@RequestBody Producto producto){

        return productoService.agregarProducto(producto);
    }

    @GetMapping("/mostrarProducto")
    public Object mostrarProducto(@RequestParam(required = false, defaultValue = "0") Integer page, @RequestParam(required = false, defaultValue = "0") Integer size ){
        return productoService.mostrarProductosPage(page, size);
    }
}
