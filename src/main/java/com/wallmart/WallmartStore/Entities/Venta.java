package com.wallmart.WallmartStore.Entities;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "Venta") //documentto
@Data //get y set

public class Venta {

    private Integer id;

    private int usuario_id;

    private Date fecha;

    private float total;

    private List<Producto> productos;


    
}
