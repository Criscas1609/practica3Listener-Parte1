package com.example.practicaListener.service;

import com.example.practicaListener.model.Product;
import com.example.practicaListener.model.Producto;

import java.util.List;

public interface ProductoService {

    List<Producto> listar();
    Boolean validateExistence(Long id);

}
