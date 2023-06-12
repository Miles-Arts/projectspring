package com.springboot.project.services;


import com.springboot.project.models.Producto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class OrderService {

    private final Logger logger = LoggerFactory.getLogger(OrderService.class);

    public void saveOrder(List<Producto> products) {
        System.out.println("---Guardando Productos en la ---DB---");

        products.forEach(product -> logger.debug("El nombre del producto: {}", product.nombre));

    }
}
