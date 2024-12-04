package com.axel.Controllers;

import com.axel.Models.Cliente;
import com.axel.services.GenericServiceImpl;
import com.axel.services.IGenericService;
import com.axel.util.HibernateUtil;

import java.util.List;

public class ControllerCliente{
    public ControllerCliente(){

    }
    public void guardarCliente(Cliente cliente){
        IGenericService<Cliente> clientes = new GenericServiceImpl<>(Cliente.class, HibernateUtil.getSessionFactory());
        clientes.save(cliente);
    }
    public void eliminarCliente(Cliente cliente){
        IGenericService<Cliente> clientes = new GenericServiceImpl<>(Cliente.class, HibernateUtil.getSessionFactory());
        clientes.delete(cliente);
    }
    public void editarCliente(Cliente cliente){
        IGenericService<Cliente> clientes = new GenericServiceImpl<>(Cliente.class, HibernateUtil.getSessionFactory());
        clientes.update(cliente);
    }
    public List<Cliente> getClientes() {
        IGenericService<Cliente> clienteIGenericService= new GenericServiceImpl<>(Cliente.class, HibernateUtil.getSessionFactory());
        return clienteIGenericService.getAll();
    }


}
