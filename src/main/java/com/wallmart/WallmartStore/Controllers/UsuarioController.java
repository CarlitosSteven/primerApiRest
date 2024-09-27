package com.wallmart.WallmartStore.Controllers;
import com.wallmart.WallmartStore.Entities.Usuario;
import com.wallmart.WallmartStore.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin(origins = "http//localhost:4200")
@RestController
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/agregarUsuario")
    public Object agregarUsuario(@RequestBody Usuario usuario){
        return this.usuarioService.agregarUsuario(usuario);
    }

    @GetMapping("/mostrarUsuarioPage")
    public Object mostrarUsuarioPage(@RequestParam(required = false, defaultValue = "0") Integer page, @RequestParam(required = false, defaultValue = "10")Integer size){
        return usuarioService.mostrarUsuarioPage(page, size);
    }

    @DeleteMapping("/eliminarUsuario/{id}")
    public void eliminarUsuario( @PathVariable Integer id){
        this.usuarioService.eliminarUsuario(id);
    }

    @PutMapping(value = "/modificarUsuario")
    public Object modificarUsuario(@RequestBody Usuario usuario){
        return this.usuarioService.modificarUsuario(usuario);
    }

    @GetMapping("/mostrarUsuarioId/{id}")
    public Object mostrarUsuarioId(@PathVariable Integer id){
        return this.usuarioService.mostrarUsuarioId(id);
    }
                    
    @PostMapping("/verificarUsuario")
    public Object verificarUsuario(@RequestBody Usuario usuario){
        return this.usuarioService.verificarUsuario(usuario.getNombreUsuario(), usuario.getContrasena());
    }
    

}
