package com.springboot.project.services;

import com.springboot.project.models.Producto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IOrderService {

    public void saveOrder(List<Producto> products);

}
