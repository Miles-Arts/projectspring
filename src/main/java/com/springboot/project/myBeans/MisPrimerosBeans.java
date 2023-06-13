package com.springboot.project.myBeans;

import com.springboot.project.models.Producto;
import com.springboot.project.services.IOrderService;
import com.springboot.project.services.OrderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;


@Configuration
public class MisPrimerosBeans {

    @Bean
    public MyBean crearMiBean () {

        return new MyBean();
    }

    @Bean
    public IOrderService instanciarOrderService() {

        boolean esProduccion = false;

        if (esProduccion) {
            return new OrderService();
        } {
            return new IOrderService() {
                @Override
                public void saveOrder(List<Producto> products) {
                    System.out.println("Guardando en base de datos Dummy (Local)");
                }
            };
        }
    }
}
