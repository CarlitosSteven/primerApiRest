package com.wallmart.WallmartStore.Entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "Producto") //documentto
@Data //get y set
public class Producto {
    @Id
    private Integer id;

    private String nombre;

    private float precio;
}
