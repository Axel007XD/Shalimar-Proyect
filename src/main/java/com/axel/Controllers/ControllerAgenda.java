package com.axel.Controllers;

import com.axel.Models.DetallePedido;
import com.axel.Models.MetodoPersonalizacion;
import com.axel.Models.Pedido;
import com.axel.Models.User;
import com.axel.services.GenericServiceImpl;
import com.axel.services.IGenericService;
import com.axel.util.HibernateUtil;

import java.util.List;

public class ControllerAgenda {

    private List <DetallePedido> detallePedidosLista;
    private List <Pedido> pedidosLista;

    public ControllerAgenda (){

    }

    private List<DetallePedido> getDetallePedidos() {
        IGenericService<DetallePedido> detallePedido= new GenericServiceImpl<>(DetallePedido.class, HibernateUtil.getSessionFactory());
        return detallePedido.getAll();
    }
    public void guardarDetallePedido(DetallePedido detallePedido){
        IGenericService<DetallePedido> detallePedidoIGenericService = new GenericServiceImpl<>(DetallePedido.class,HibernateUtil.getSessionFactory());
        detallePedidoIGenericService.save(detallePedido);
    }

    private List<Pedido> getPedidos() {
        IGenericService<Pedido> pedidoGenericService= new GenericServiceImpl<>(Pedido.class, HibernateUtil.getSessionFactory());
        return pedidoGenericService.getAll();
    }
    public void guardarMetodoPersonalizado(MetodoPersonalizacion metodoPersonalizacion){
        IGenericService<MetodoPersonalizacion> metodoPersonalizacionIGenericService = new GenericServiceImpl<>(MetodoPersonalizacion.class,HibernateUtil.getSessionFactory());
        metodoPersonalizacionIGenericService.save(metodoPersonalizacion);
    }
    private List<MetodoPersonalizacion> getMetodosPersonalizacion() {
        IGenericService<MetodoPersonalizacion> metodoPersonalizacionIGenericService= new GenericServiceImpl<>(MetodoPersonalizacion.class, HibernateUtil.getSessionFactory());
        return metodoPersonalizacionIGenericService.getAll();
    }
    public void guardarPedido(Pedido pedido){
        IGenericService<Pedido> pedidoIGenericService = new GenericServiceImpl<>(Pedido.class,HibernateUtil.getSessionFactory());
        pedidoIGenericService.save(pedido);
    }




}
