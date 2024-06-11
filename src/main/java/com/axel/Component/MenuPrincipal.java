package com.axel.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPrincipal extends JMenuBar {


    JMenu menuAcciones;
    JMenuItem menuAddAgenda;
    JMenuItem menuAddTrabajador;
    JMenuItem menuAddPedido;
    JMenuItem menuAddCliente;

    public MenuPrincipal(){
        //setLayout(new BorderLayout());

        menuAcciones = new JMenu("Acciones");
        menuAddAgenda = new JMenuItem("Agregar a Agenda");
        menuAddTrabajador = new JMenuItem("Agregar a Trabajador");
        menuAddPedido = new JMenuItem("Agregar a Pedido");
        menuAddCliente = new JMenuItem("Agregar a Cliente");

        menuAcciones.add(menuAddAgenda);
        menuAcciones.add(menuAddTrabajador);
        menuAcciones.add(menuAddPedido);
        menuAcciones.add(menuAddCliente);
        add(menuAcciones);

    }

    public JMenu getMenuAcciones() {
        return menuAcciones;
    }

    public void setMenuAcciones(JMenu menuAcciones) {
        this.menuAcciones = menuAcciones;
    }

    public JMenuItem getMenuAddCliente() {
        return menuAddCliente;
    }

    public void setMenuAddCliente(JMenuItem menuAddCliente) {
        this.menuAddCliente = menuAddCliente;
    }

    public JMenuItem getMenuAddAgenda() {
        return menuAddAgenda;
    }

    public void setMenuAddAgenda(JMenuItem menuAddAgenda) {
        this.menuAddAgenda = menuAddAgenda;
    }

    public JMenuItem getMenuAddPedido() {
        return menuAddPedido;
    }

    public void setMenuAddPedido(JMenuItem menuAddPedido) {
        this.menuAddPedido = menuAddPedido;
    }

    public JMenuItem getMenuAddTrabajador() {
        return menuAddTrabajador;
    }

    public void setMenuAddTrabajador(JMenuItem menuAddTrabajador) {
        this.menuAddTrabajador = menuAddTrabajador;
    }
}
