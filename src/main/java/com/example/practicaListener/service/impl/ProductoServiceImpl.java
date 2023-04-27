package com.example.practicaListener.service.impl;


import com.example.practicaListener.model.Producto;
import com.example.practicaListener.service.ProductoService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductoServiceImpl implements ProductoService {

    List<Producto> products = new ArrayList();

    public List<Producto> listar() {
        return Arrays.asList(new Producto(1, "notebook", "computacion", 175000.0),
                new Producto(2, "mesa escritorio", "oficina", 100000.0),
                new Producto(3, "teclado mecanico", "computacion", 40000.0),
                new Producto(4,"Audifonos inalambricos", "computacion",50000.0),
                new Producto(5,"Escritorio de madera","Oficina",150000.0),
                new Producto(6,"Cargador para Iphone", "computacion",60000.0)
        );
    }

    public Boolean validateExistence(Long id){
        products = listar();
        return products.stream()
                .anyMatch(producto -> producto.getId() == id);
    }

}
