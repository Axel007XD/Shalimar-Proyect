package com.axel.Controllers;

import com.axel.Models.Pedido;
import com.axel.Models.Producto;
import com.axel.services.GenericServiceImpl;
import com.axel.services.IGenericService;
import com.axel.util.HibernateUtil;

import java.util.List;

public class ControllerProducto {

    public List<Producto> getProductos() {
            IGenericService<Producto> productoGenericService= new GenericServiceImpl<>(Producto.class, HibernateUtil.getSessionFactory());
        return productoGenericService.getAll();
    }
    public void guardarProducto(Producto producto){
        IGenericService<Producto> productoGenericService = new GenericServiceImpl<>(Producto.class,HibernateUtil.getSessionFactory());
        productoGenericService.save(producto);
    }

}
