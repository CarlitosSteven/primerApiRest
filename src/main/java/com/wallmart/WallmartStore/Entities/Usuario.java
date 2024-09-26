package com.wallmart.WallmartStore.Entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "usuario")
@Data
public class Usuario {

    @Id
    private Integer id;

    private String nombre;

    private String nombreUsuario;

    private String contrasena;
}
