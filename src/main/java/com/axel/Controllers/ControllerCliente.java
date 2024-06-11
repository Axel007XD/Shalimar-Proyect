package com.axel.Controllers;

import com.axel.Models.Cliente;
import com.axel.Models.Trabajador;
import com.axel.Views.ViewAddCliente;
import com.axel.Views.ventanaMenuPrincipal;
import com.axel.services.GenericServiceImpl;
import com.axel.services.IGenericService;
import com.axel.util.HibernateUtil;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerCliente implements ActionListener {
    ViewAddCliente viewAddCliente = new ViewAddCliente();
    ventanaMenuPrincipal ventanaMenuPrincipal;

    public ControllerCliente(ViewAddCliente viewAddCliente, ventanaMenuPrincipal ventanaMenuPrincipal) {
        this.viewAddCliente = viewAddCliente;
        this.ventanaMenuPrincipal = ventanaMenuPrincipal;
        this.viewAddCliente.getBtnAdd().addActionListener(this);
    }

    private static void guardarCliente(Cliente cliente){
        IGenericService<Cliente> clientes = new GenericServiceImpl<>(Cliente.class, HibernateUtil.getSessionFactory());
        clientes.save(cliente);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==viewAddCliente.getBtnAdd()){
            String name=viewAddCliente.getTxtName().getText();
            String cedula=viewAddCliente.getTxtCedula().getText();
            String direccion=viewAddCliente.getTxtDireccion().getText();
            String telefono=viewAddCliente.getTxtTelefono().getText();

            if (name.isEmpty() || cedula.isEmpty() || direccion.isEmpty() || telefono.isEmpty()){
                System.out.println("Datos vacios");
            }else {
                Cliente cliente = new Cliente(name, cedula, telefono, direccion);
                guardarCliente(cliente);
                viewAddCliente.limpiarCampos();

                System.out.println("Registro agregado");

            }
        }


    }



}
