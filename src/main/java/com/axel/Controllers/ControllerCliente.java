package com.axel.Controllers;

import com.axel.Models.Cliente;
import com.axel.Views.ViewAddCliente;
import com.axel.Views.ventanaMenuPrincipal;
import com.axel.services.GenericServiceImpl;
import com.axel.services.IGenericService;
import com.axel.util.HibernateUtil;

public class ControllerCliente{
    public ControllerCliente(){

    }
    private void guardarCliente(Cliente cliente){
        IGenericService<Cliente> clientes = new GenericServiceImpl<>(Cliente.class, HibernateUtil.getSessionFactory());
        clientes.save(cliente);
    }
    private void eliminarCliente(Cliente cliente){
        IGenericService<Cliente> clientes = new GenericServiceImpl<>(Cliente.class, HibernateUtil.getSessionFactory());
        clientes.delete(cliente);
    }
    private void editarCliente(Cliente cliente){
        IGenericService<Cliente> clientes = new GenericServiceImpl<>(Cliente.class, HibernateUtil.getSessionFactory());
        clientes.update(cliente);
    }


}
