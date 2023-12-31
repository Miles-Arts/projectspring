package com.springboot.project.services;


import com.springboot.project.models.Producto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;


//@Service
public class OrderService implements IOrderService {

    @Value("${misurls.database}")
    private String databaseUrl;
    //private final String databaseUrl = "https://mibasededatos.com";

    private final Logger logger = LoggerFactory.getLogger(OrderService.class);

    public OrderService() {
    }

    public void saveOrder(List<Producto> products) {
        System.out.println("---Guardando Productos en la ---DB--- || La URL: " + databaseUrl);

        products.forEach(product -> logger.debug("El nombre del producto: {}", product.nombre));

    }
}
